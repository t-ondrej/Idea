package services;

import dao.interfaces.IEventDao;
import entity.impl.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.interfaces.IEventService;

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
}
