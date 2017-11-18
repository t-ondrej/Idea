package dao;

import dao.interfaces.IAttachDao;
import entity.impl.Attach;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tomas on 8.11.2017.
 */
@Transactional
@Repository
public class AttachDao extends AbstractEntityDao<Attach, Long> implements IAttachDao {

    public AttachDao() {
        super("Attach", Attach.class);
    }
}
