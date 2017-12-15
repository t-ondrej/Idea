package sk.upjs.ics.dao;

import sk.upjs.ics.dao.interfaces.INodeDao;
import sk.upjs.ics.entity.impl.Node;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tomas on 8.11.2017.
 */
@Transactional
@Repository
public class NodeDao extends AbstractDao<Node, Long> implements INodeDao {

    public NodeDao() {
        super("Node", Node.class);
    }
}
