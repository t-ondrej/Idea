package dao;

import dao.interfaces.ISourceDao;
import entity.impl.Source;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tomas on 8.11.2017.
 */
@Transactional
@Repository
public class SourceDao extends AbstractDao<Source, Long> implements ISourceDao {

    public SourceDao() {
        super("Source", Source.class);
    }
}
