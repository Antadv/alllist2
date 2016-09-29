package com.coderbike.core.service;


import com.coderbike.core.entity.BaseEntity;
import com.coderbike.core.jpa.GenericJpaDao;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 17:30
 */
@Transactional(readOnly = true)
public abstract class GenericServiceImpl<T extends BaseEntity, ID extends Serializable, DAO extends GenericJpaDao<T, ID>>
        implements GenericService<T, ID, DAO> {

    public T save(T entity) {
        return getDao().save(entity);
    }

    public void delete(T entity) {
        getDao().delete(entity);
    }

    public void deleteAll(List<T> list) {
        getDao().delete(list);
    }

    public T findById(ID id) {
        return getDao().findOne(id);
    }

    public List<T> findList(List<ID> ids) {
        return getDao().findAll(ids);
    }
}
