package sk.upjs.ics.services;

import sk.upjs.ics.dao.interfaces.INodeDao;
import sk.upjs.ics.entity.impl.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.upjs.ics.predicates.PredicateInfo;
import sk.upjs.ics.services.interfaces.INodeService;

import java.util.Collections;
import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
@Service
public class NodeService implements INodeService {

    @Autowired
    private final INodeDao nodeDao;

    public NodeService(INodeDao nodeDao) {
        this.nodeDao = nodeDao;
    }

    @Override
    public List<Node> getAll() {
        return nodeDao.getAll();
    }

    @Override
    public void merge(Node entity) {
        nodeDao.merge(entity);
    }

    @Override
    public void remove(Node entity) {
        nodeDao.remove(entity);
    }

    @Override
    public Node findById(Long id) {
        return nodeDao.findById(id);
    }

    @Override
    public List<Node> findAll(PredicateInfo[] predicateInfo) {
        if (predicateInfo == null || predicateInfo.length < 1) {
            return Collections.emptyList();
        }

        return nodeDao.findAll(predicateInfo);
    }

    @Override
    public List<Node> doFulltextSearch(String target) {
        if (target == null) {
            return Collections.emptyList();
        }

        final String[] colNames = new String[] {
            "type", "name", "aggrWin", "sw", "note"
        };

        return nodeDao.doFulltextSearch(colNames, target);
    }
}
