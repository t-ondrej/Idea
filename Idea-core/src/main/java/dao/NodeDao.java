package dao;

import dao.interfaces.INodeDao;
import entity.impl.Node;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tomas on 8.11.2017.
 */
@Transactional
@Repository
public class NodeDao extends AbstractEntityDao<Node, Long> implements INodeDao {

    public NodeDao() {
        super("Node", Node.class);
    }
}
