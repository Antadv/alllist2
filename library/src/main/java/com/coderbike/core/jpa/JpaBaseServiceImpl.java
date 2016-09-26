package com.coderbike.core.jpa;


import com.coderbike.core.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 17:30
 */
@Transactional(readOnly = true)
public abstract class JpaBaseServiceImpl<T extends BaseEntity, ID extends Serializable, DAO extends JpaBaseDao<T, ID>>
        extends JpaBaseDaoImpl<T, ID, DAO> implements JpaBaseService<T, ID, DAO> {

    /**
     * save
     *
     * @param entity
     */
    public T save(T entity) {
        Date date = new Date();
        if (entity.getId() == null) {
            entity.setFirstTime(date);
        }
        entity.setLastTime(date);
        return getDao().save(entity);
    }

    /**
     * deleteList
     *
     * @param list
     */
    public void deleteList(List<T> list) {

    }

    /**
     * get
     *
     * @param id
     * @return
     */
    public T findById(ID id) {
        return null;
    }

    /**
     * findList
     *
     * @param ids
     * @return
     */
    public List<T> findList(List<ID> ids) {
        return null;
    }
}
