package com.coderbike.core.service;

import com.coderbike.core.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;

/**
 * <p>通用crud service 接口<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/9/26 17:28
 */
public interface GenericService<T extends BaseEntity, ID extends Serializable> {

    Class<T> getEntityClass();

    List<T> findAll(Specification<T> spec);

    Page<T> findAll(Specification<T> spec, Pageable pageable);

    List<T> findAll(Specification<T> spec, Sort sort);

    long count(Specification<T> spec);

    List<T> findAll();

    List<T> findAll(Sort sort);

    List<T> findAll(Iterable<ID> ids);

    T saveAndFlush(T entity);

    T save(T entity);

    void delete(T entity);

    void delete(ID id);

    T findById(ID id);

    T deleteByStatus(ID id,String delReason);

    T findByIdAndNotDelete(ID id);

}
