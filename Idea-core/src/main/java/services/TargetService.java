package services;

import dao.interfaces.ITargetDao;
import entity.impl.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import predicates.PredicateInfo;
import services.interfaces.ITargetService;

import java.util.Collections;
import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@Service
public class TargetService implements ITargetService {

    @Autowired
    private final ITargetDao targetDao;

    public TargetService(ITargetDao targetDao) {
        this.targetDao = targetDao;
    }

    @Override
    public List<Target> getAll() {
        return targetDao.getAll();
    }

    @Override
    public void merge(Target entity) {
        targetDao.merge(entity);
    }

    @Override
    public void remove(Target entity) {
        targetDao.remove(entity);
    }

    @Override
    public Target findById(Long id) {
        return targetDao.findById(id);
    }

    @Override
    public List<Target> findAll(PredicateInfo[] predicateInfo) {
        if (predicateInfo == null || predicateInfo.length < 1) {
            return Collections.emptyList();
        }

        return null;
    }

    @Override
    public List<Target> doFulltextSearch(String target) {
        if (target == null) {
            return Collections.emptyList();
        }

        final String[] colNames = new String[] {
                "attachHand", "type", "ip6", "netname", "ip4",
                "url", "port", "hostname", "proto",
                "description", "mac", "email", "note",
                "asn", "router", "ref"
        };

        return targetDao.doFulltextSearch(colNames, target);
    }
}
