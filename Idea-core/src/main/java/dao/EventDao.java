package dao;

import dao.interfaces.IEventDao;
import entity.impl.Event;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by Tomas on 8.11.2017.
 */
@Transactional
@Repository
public class EventDao extends AbstractEntityDao<Event, String> implements IEventDao {

    public EventDao() {
        super("Event", Event.class);
    }
}
