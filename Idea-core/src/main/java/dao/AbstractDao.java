package dao;

import dao.interfaces.IDao;
import entity.IEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import predicates.PredicateBuilder;
import predicates.PredicateInfo;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Tomas on 8.11.2017.
 */
@Transactional
@Repository
public abstract class AbstractDao<T extends IEntity, ID> implements IDao<T, ID> {

    private String tableName;

    private Class<T> persistentClass;

    private Logger logger;

    @PersistenceContext
    private EntityManager entityManager;

    private PredicateBuilder predicateBuilder;

    public AbstractDao(String tableName, Class<T> persistentClass) {
        this.tableName = tableName;
        this.persistentClass = persistentClass;

        logger = Logger.getLogger(persistentClass.getName());
    }

    @PostConstruct
    private void postConstruct() {
        this.predicateBuilder = new PredicateBuilder(entityManager.getCriteriaBuilder());
    }

    public List<T> getAll() {
        logger.info("Getting all from " + tableName);

        TypedQuery<T> query = entityManager.createQuery("from " + tableName, persistentClass);
        return query.getResultList();
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
        return entityManager.find(this.persistentClass, id);
    }

    public List<T> findAll(PredicateInfo[] predicateInfos) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
        Root<T> rootEntity = criteriaQuery.from(persistentClass);

        Predicate[] predicates = predicateBuilder
                .parsePredicates(predicateInfos, rootEntity);

        criteriaQuery
            .select(rootEntity)
            .where(criteriaBuilder.and(predicates));

        return entityManager
            .createQuery(criteriaQuery)
            .getResultList();
    }

    public List<T> doFulltextSearch(String[] colNames, String target) {
        return entityManager
                .createQuery(
                    String.format("select e from %s e where fts(%s, :target) = true",
                        tableName,
                        String.join(",", colNames)),
                    persistentClass)
                .setParameter("target", target)
                .getResultList();
    }
}
