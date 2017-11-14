package dao.impl;

import dao.AbstractEntityDao;
import entity.impl.Node;

/**
 * Created by Tomas on 8.11.2017.
 */
public class NodeDao extends AbstractEntityDao<Node> {

    public NodeDao() {
        super("Node", Node.class);
    }
}
