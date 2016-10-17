package com.coderbike.core.repository;

import com.coderbike.core.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * <p>通用crud dao<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/9/26 16:13
 */
public interface GenericJpaDao<T extends BaseEntity, ID extends Serializable>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    /**
     * 根据id和查询没有被逻辑删除的实体
     */
    T findByIdAndDeleteStatusFalse(ID id);
}
