package dao.impl;

import dao.AbstractEntityDao;
import entity.impl.Attach;

/**
 * Created by Tomas on 8.11.2017.
 */
public class AttachDao extends AbstractEntityDao<Attach> {

    public AttachDao() {
        super("Attach", Attach.class);
    }
}
