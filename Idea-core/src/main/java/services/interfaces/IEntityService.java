package services.interfaces;

import entity.IEntity;
import predicates.PredicateInfo;

import java.util.List;

/**
 * Created by Tomas on 18.11.2017.
 */
public interface IEntityService<T extends IEntity, ID> {
    List<T> getAll();

    void merge(T entity);

    void remove(T entity);

    T findById(ID id);

    List<T> findAll(PredicateInfo[] predicateInfo);

    List<T> doFulltextSearch(String target);
}
