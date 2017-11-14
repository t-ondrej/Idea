package dao;

import entity.IEntity;

import java.util.List;

/**
 * Created by Tomas on 8.11.2017.
 */
public interface IEntityDao<T extends IEntity> {

    List getAll();

    void merge(T entity);

    void remove(T entity);

    T findById(Long id);

    T findById(String id);
}
