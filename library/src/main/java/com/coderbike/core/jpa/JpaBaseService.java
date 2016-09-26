package com.coderbike.core.jpa;

import com.coderbike.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 17:28
 */
public interface JpaBaseService<T extends BaseEntity, ID extends Serializable, DAO extends JpaBaseDao<T, ID>> {

    /**
     * save
     *
     * @param entity
     */
    T save(T entity);

    /**
     * delete
     *
     * @param entity
     */
    void delete(T entity);

    /**
     * deleteList
     *
     * @param list
     */
    void deleteList(List<T> list);

    /**
     * deleteList
     */
    void deleteAll();

    /**
     * get
     *
     * @param id
     * @return
     */
    T findById(ID id);

    /**
     * findList
     *
     * @param ids
     * @return
     */
    List<T> findList(List<ID> ids);

    /**
     * findAll
     *
     * @return
     */
    List<T> findAll();
}
