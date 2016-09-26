package com.coderbike.core.service;

import com.coderbike.core.entity.BaseEntity;
import com.coderbike.core.jpa.GenericJpaDao;
import com.coderbike.core.mybatis.GenericMybatisDao;

import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 17:28
 */
public interface GenericService<T extends BaseEntity,
                                ID extends Serializable,
                                JpaDao extends GenericJpaDao<T, ID>,
                                MybatisDao extends GenericMybatisDao<T, ID>> {

    JpaDao getJpaDao();
    MybatisDao getMybatisDao();

    T findByIdNotDelete(ID id);
}
