package com.coderbike.core.jpa;

import com.coderbike.core.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 16:13
 */
public interface GenericJpaDao<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {

    @Query("from T t where t.deleteStatus=false and t.id=?")
    T findByIdNotDelete(ID id);

}
