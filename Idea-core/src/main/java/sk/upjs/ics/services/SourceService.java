package sk.upjs.ics.services;

import sk.upjs.ics.dao.interfaces.ISourceDao;
import sk.upjs.ics.entity.impl.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.upjs.ics.predicates.PredicateInfo;
import sk.upjs.ics.services.interfaces.ISourceService;

import java.util.Collections;
import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@Service
public class SourceService implements ISourceService {

    @Autowired
    private final ISourceDao sourceDao;

    public SourceService(ISourceDao sourceDao) {
        this.sourceDao = sourceDao;
    }

    @Override
    public List<Source> getAll() {
        return sourceDao.getAll();
    }

    @Override
    public void merge(Source entity) {
        sourceDao.merge(entity);
    }

    @Override
    public void mergeAll(List<Source> entities) {
        sourceDao.mergeAll(entities);
    }

    @Override
    public void remove(Source entity) {
        sourceDao.remove(entity);
    }

    @Override
    public void removeById(Long id) {
        sourceDao.removeById(id);
    }

    @Override
    public Source findById(Long id) {
        return sourceDao.findById(id);
    }

    @Override
    public List<Source> findAll(PredicateInfo[] predicateInfo) {
        if (predicateInfo == null || predicateInfo.length < 1) {
            return Collections.emptyList();
        }

        return null;
    }

    @Override
    public List<Source> doFulltextSearch(String target) {
        if (target == null) {
            return Collections.emptyList();
        }

        final String[] colNames = new String[] {
            "attachHand", "type", "ip6", "netname", "ip4",
            "url", "port", "hostname", "proto",
            "description", "mac", "email", "note",
            "asn", "router", "ref"
        };

        return sourceDao.doFulltextSearch(colNames, target);
    }
}
