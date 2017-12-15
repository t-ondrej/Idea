package sk.upjs.ics.dao.interfaces;

import sk.upjs.ics.entity.IEntity;
import sk.upjs.ics.predicates.PredicateInfo;

import java.util.List;

/**
 * Created by Tomas on 8.11.2017.
 */
public interface IDao<T extends IEntity, ID> {

    List<T> getAll();

    void merge(T entity);

    void remove(T entity);

    T findById(ID id);

    List<T> findAll(PredicateInfo[] predicateInfos);

    List<T> doFulltextSearch(String[] colName, String target);
}
