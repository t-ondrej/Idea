package sk.upjs.ics.services;

import sk.upjs.ics.dao.interfaces.IEventDao;
import sk.upjs.ics.entity.impl.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.upjs.ics.predicates.PredicateInfo;
import sk.upjs.ics.services.interfaces.IEventService;

import java.util.Collections;
import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@Service
public class EventService implements IEventService {

    @Autowired
    private final IEventDao eventDao;

    public EventService(IEventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public List<Event> getAll() {
        return eventDao.getAll();
    }

    @Override
    public void merge(Event entity) {
        eventDao.merge(entity);
    }

    @Override
    public void remove(Event entity) {
        eventDao.remove(entity);
    }

    @Override
    public Event findById(String id) {
        return eventDao.findById(id);
    }

    @Override
    public List<Event> findAll(PredicateInfo[] predicateInfo) {
        if (predicateInfo == null || predicateInfo.length < 1) {
            return Collections.emptyList();
        }

        return eventDao.findAll(predicateInfo);
    }

    @Override
    public List<Event> doFulltextSearch(String target) {
        if (target == null) {
            return Collections.emptyList();
        }

        final String[] colNames = new String[] {
            "format", "createTime", "detectTime", "winStartTime", "winEndTime",
            "eventTime", "ceaseTime", "confidence", "note",
            "connCount", "category", "ref", "altnames",
            "correlId", "aggrId", "predId", "relId", "flowCount", "packetCount",
            "byteCount", "description"
        };

        return eventDao.doFulltextSearch(colNames, target);
    }
}
