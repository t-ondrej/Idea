package dao.impl;

import dao.AbstractEntityDao;
import entity.impl.Event;


/**
 * Created by Tomas on 8.11.2017.
 */
public class EventDao extends AbstractEntityDao<Event> {

    public EventDao() {
        super("Event", Event.class);
    }
}
