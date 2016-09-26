package com.coderbike.core.jpa;

import com.coderbike.core.entity.BaseEntity;

import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 17:18
 */
public abstract class JpaBaseDaoImpl<T extends BaseEntity, ID extends Serializable, DAO extends JpaBaseDao<T, ID>> implements JpaBaseDao<T, ID> {
}
