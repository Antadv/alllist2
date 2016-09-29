package com.coderbike.core.service;

import com.coderbike.core.entity.BaseEntity;
import com.coderbike.core.jpa.GenericJpaDao;

import java.io.Serializable;
import java.util.List;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 17:28
 */
public interface GenericService<T extends BaseEntity, ID extends Serializable, DAO extends GenericJpaDao<T, ID>> {

    DAO getDao();

    T save(T entity);

    void delete(T entity);

    void deleteAll(List<T> list);

    T findById(ID id);

    List<T> findList(List<ID> ids);
}
