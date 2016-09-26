package com.coderbike.core.jpa;


import com.coderbike.core.entity.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 17:30
 */
@Transactional(readOnly = true)
public abstract class JpaBaseServiceImpl<T extends BaseEntity, ID extends Serializable, DAO extends JpaBaseDao<T, ID>>
        extends JpaBaseDaoImpl<T, ID, DAO> implements JpaBaseService<T, ID, DAO> {

}
