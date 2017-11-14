package dao.impl;

import dao.AbstractEntityDao;
import entity.impl.Target;

/**
 * Created by Tomas on 8.11.2017.
 */
public class TargetDao extends AbstractEntityDao<Target> {

    public TargetDao() {
        super("Target", Target.class);
    }
}
