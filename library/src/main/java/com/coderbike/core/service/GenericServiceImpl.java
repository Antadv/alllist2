package com.coderbike.core.service;


import com.coderbike.core.entity.BaseEntity;
import com.coderbike.core.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/9/26 17:30
 */
@Transactional(readOnly = true)
public abstract class GenericServiceImpl<T extends BaseEntity, ID extends Serializable> implements GenericService<T, ID> {

    @Autowired
    protected BaseRepository<T, ID> baseRepository;

    @Override
    public Class<T> getEntityClass() {
        return null;
    }

    @Override
    public List<T> findAll(Specification<T> spec) {
        return baseRepository.findAll(spec);
    }

    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return baseRepository.findAll(spec, pageable);
    }

    @Override
    public List<T> findAll(Specification<T> spec, Sort sort) {
        return baseRepository.findAll(spec, sort);
    }

    @Override
    public long count(Specification<T> spec) {
        return baseRepository.count(spec);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return findAll(sort);
    }

    @Override
    public List<T> findAll(Iterable<ID> ids) {
        return baseRepository.findAll(ids);
    }

    @Override
    @Transactional
    public T saveAndFlush(T entity) {
        return null;
    }

    /**
     * 保存
     */
    @Override
    @Transactional
    public T save(T entity) {
        Assert.notNull(entity, "entity is null");
        Date date = new Date();
        if (entity.getId() == null) {
            entity.setCreateDate(date);
        }
        entity.setUpdateDate(date);
        return baseRepository.save(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        baseRepository.delete(entity);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        baseRepository.delete(id);
    }

    @Override
    public T findById(ID id) {
        return baseRepository.findOne(id);
    }

    @Override
    @Transactional
    public T deleteByStatus(ID id, String delReason) {
        Assert.notNull(id, "id is null");

        T entity = findById(id);
        entity.setDeleteStatus(false);
        return save(entity);
    }

    @Override
    @Transactional
    public T findByIdAndNotDelete(ID id) {
        return baseRepository.findByIdAndDeleteStatusFalse(id);
    }

}
