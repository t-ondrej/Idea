package dao;

import dao.interfaces.ITargetDao;
import entity.impl.Target;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tomas on 8.11.2017.
 */
@Transactional
@Repository
public class TargetDao extends AbstractDao<Target, Long> implements ITargetDao {

    public TargetDao() {
        super("Target", Target.class);
    }
}
