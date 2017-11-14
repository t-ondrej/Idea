package dao.impl;

import dao.AbstractEntityDao;
import entity.impl.Source;

/**
 * Created by Tomas on 8.11.2017.
 */
public class SourceDao extends AbstractEntityDao<Source> {

    public SourceDao() {
        super("Source", Source.class);
    }
}
