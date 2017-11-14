package dao;

import entity.IEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Tomas on 8.11.2017.
 */
public abstract class AbstractEntityDao<T extends IEntity> implements IEntityDao<T> {

    private String tableName;

    private Class<T> persistentClass;

    private Logger logger;

    private SessionFactory sessionFactory;

    public AbstractEntityDao(String tableName, Class<T> persistentClass) {
        this.tableName = tableName;
        this.persistentClass = persistentClass;

        logger = Logger.getLogger(persistentClass.getName());
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<T> getAll() {
        logger.info("Getting all from " + tableName);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<T> result = session.createQuery("from " + tableName).list();
        session.getTransaction().commit();

        return result;
    }

    @Override
    public void merge(final T entity) {
        logger.info("Merging " + entity.toString());

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.saveOrUpdate(entity);
        session.getTransaction().commit();
    }

    @Override
    public void remove(final T entity) {
        logger.info("Removing " + entity.toString());

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.delete(entity);
        //session.remove(entity);
        session.getTransaction().commit();
    }

    @Override
    public T findById(final Long id) {
        logger.info("Trying to find " + tableName + " with id: " + id);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        T result = (T) session.get(this.persistentClass, id);
        session.getTransaction().commit();

        return result;
    }

    @Override
    public T findById(final String id) {
        logger.info("Finding " + tableName + " with id: " + id);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        T result = (T) session.get(this.persistentClass, id);
        session.getTransaction().commit();

        return result;
    }
}
