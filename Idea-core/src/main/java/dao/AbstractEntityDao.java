package dao;

import dao.interfaces.IEntityDao;
import entity.IEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Tomas on 8.11.2017.
 */
@Transactional
@Repository
public abstract class AbstractEntityDao<T extends IEntity, ID> implements IEntityDao<T, ID> {

    private String tableName;

    private Class<T> persistentClass;

    private Logger logger;

    @PersistenceContext
    private EntityManager entityManager;

    public AbstractEntityDao(String tableName, Class<T> persistentClass) {
        this.tableName = tableName;
        this.persistentClass = persistentClass;

        logger = Logger.getLogger(persistentClass.getName());
    }

    public List<T> getAll() {
        logger.info("Getting all from " + tableName);

        TypedQuery<T> query = entityManager.createQuery("from " + tableName, persistentClass);
        List<T> result = query.getResultList();

        return result;
    }

    public void merge(T entity) {
        logger.info("Merging " + entity.toString());

        entityManager.persist(entity);
    }

    public void remove(T entity) {
        logger.info("Removing " + entity.toString());

        entityManager.remove(entity);
    }

    public T findById(ID id) {
        logger.info("Trying to find " + tableName + " with id: " + id);

        T result = entityManager.find(this.persistentClass, id);
        return result;
    }
}
