package com.coderbike.core.repository;

import com.coderbike.core.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * <p>通用crud dao<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/9/26 16:13
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    T findByIdAndDeleteStatusFalse(ID id);
}
