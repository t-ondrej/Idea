package dao.interfaces;

import entity.IEntity;

import java.util.List;

/**
 * Created by Tomas on 8.11.2017.
 */
public interface IDao<T extends IEntity, ID> {

    List<T> getAll();

    void merge(T entity);

    void remove(T entity);

    T findById(ID id);
}
