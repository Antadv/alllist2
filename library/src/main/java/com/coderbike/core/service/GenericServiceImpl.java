package com.coderbike.core.service;


import com.coderbike.core.entity.BaseEntity;
import com.coderbike.core.repository.GenericJpaDao;
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
    protected GenericJpaDao<T, ID> genericJpaDao;

    /**
     * 获取实体类型
     *
     * @return
     */
    @Override
    public Class<T> getEntityClass() {
        return null;
    }

    /**
     * 查找所有
     *
     * @param spec
     * @return
     */
    @Override
    public List<T> findAll(Specification<T> spec) {
        return genericJpaDao.findAll(spec);
    }

    /**
     * 分页查找
     *
     * @param spec
     * @param pageable
     * @return
     */
    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return genericJpaDao.findAll(spec, pageable);
    }

    /**
     * 排序查找
     *
     * @param spec
     * @param sort
     * @return
     */
    @Override
    public List<T> findAll(Specification<T> spec, Sort sort) {
        return genericJpaDao.findAll(spec, sort);
    }

    /**
     * 获取记录数
     *
     * @param spec
     * @return
     */
    @Override
    public long count(Specification<T> spec) {
        return genericJpaDao.count(spec);
    }

    /**
     * 查找所有
     *
     * @return
     */
    @Override
    public List<T> findAll() {
        return genericJpaDao.findAll();
    }

    /**
     * 查找所有并排序
     *
     * @param sort
     * @return
     */
    @Override
    public List<T> findAll(Sort sort) {
        return findAll(sort);
    }

    /**
     * 根据ids 查找
     *
     * @param ids
     * @return
     */
    @Override
    public List<T> findAll(Iterable<ID> ids) {
        return genericJpaDao.findAll(ids);
    }

    /**
     * 刷新session
     */
    @Override
    public void flush() {
        genericJpaDao.flush();
    }

    /**
     * 刷新并保存
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional
    public T saveAndFlush(T entity) {
        return null;
    }

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional
    public T save(T entity) {
        Assert.notNull(entity, "entity is null");
        Date date = new Date();
        if (entity.getId() == null) {
            entity.setFirstTime(date);
        }
        entity.setLastTime(date);
        return genericJpaDao.save(entity);
    }

    /**
     * 删除实体
     *
     * @param entity
     */
    @Override
    @Transactional
    public void delete(T entity) {
        genericJpaDao.delete(entity);
    }

    /**
     * 根据id物理删除
     *
     * @param id
     */
    @Override
    @Transactional
    public void delete(ID id) {
        genericJpaDao.delete(id);
    }

    @Override
    public T findById(ID id) {
        return genericJpaDao.findOne(id);
    }

    /**
     * 绑定模型中的基础属性：创建人、创建时间、修改人、修改时间
     *
     * @param entity 要保存或修改的实体
     */
    @Override
    public void bindModelWithBaseProperty(T entity) {

    }

    /**
     * 逻辑删除
     *
     * @param entity
     * @param delReason
     * @return
     */
    @Override
    @Transactional
    public T deleteByStatus(T entity, String delReason) {
        Assert.notNull(entity, "entity is null");

        entity.setDeleteStatus(false);
        entity.setDelReason(delReason);
        return save(entity);
    }

    /**
     * 根据id逻辑删除
     *
     * @param id
     * @param delReason
     * @return
     */
    @Override
    @Transactional
    public T deleteByStatus(ID id, String delReason) {
        Assert.notNull(id, "id is null");

        T entity = findById(id);
        entity.setDeleteStatus(false);
        return save(entity);
    }

    /**
     * 根据id查找，没有逻辑删除
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public T findByIdAndNotDelete(ID id) {
        return genericJpaDao.findByIdAndDeleteStatusFalse(id);
    }

    /**
     * 获取数据库时间
     *
     * @return
     */
    @Override
    public Date getCurrentDate() {
        return null;
    }
}
