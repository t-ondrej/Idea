package sk.upjs.ics.dao;

import sk.upjs.ics.dao.interfaces.IAttachDao;
import sk.upjs.ics.entity.impl.Attach;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tomas on 8.11.2017.
 */
@Transactional
@Repository
public class AttachDao extends AbstractDao<Attach, Long> implements IAttachDao {

    public AttachDao() {
        super("Attach", Attach.class);
    }
}
