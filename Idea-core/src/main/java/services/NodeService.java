package services;

import dao.interfaces.INodeDao;
import entity.impl.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.interfaces.INodeService;

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
}
