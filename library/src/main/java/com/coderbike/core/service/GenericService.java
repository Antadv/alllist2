package com.coderbike.core.service;

import com.coderbike.core.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>通用crud service 接口<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/9/26 17:28
 */
public interface GenericService<T extends BaseEntity, ID extends Serializable> {

    /**
     * 获取实体类型
     * @return
     */
    Class<T> getEntityClass();

    /**
     * 查找所有
     * @param spec
     * @return
     */
    List<T> findAll(Specification<T> spec);

    /**
     * 分页查找
     * @param spec
     * @param pageable
     * @return
     */
    Page<T> findAll(Specification<T> spec, Pageable pageable);

    /**
     * 排序查找
     * @param spec
     * @param sort
     * @return
     */
    List<T> findAll(Specification<T> spec, Sort sort);

    /**
     * 获取记录数
     * @param spec
     * @return
     */
    long count(Specification<T> spec);

    /**
     * 查找所有
     * @return
     */
    List<T> findAll();

    /**
     * 查找所有并排序
     * @param sort
     * @return
     */
    List<T> findAll(Sort sort);

    /**
     * 根据ids 查找
     * @param ids
     * @return
     */
    List<T> findAll(Iterable<ID> ids);

    /**
     * 刷新session
     */
    void flush();

    /**
     * 刷新并保存
     * @param entity
     * @return
     */
    T saveAndFlush(T entity);

    /**
     * 保存
     * @param entity
     * @return
     */
    T save(T entity);

    /**
     * 删除实体
     * @param entity
     */
    void delete(T entity);

    /**
     * 根据id物理删除
     * @param id
     */
    void delete(ID id);

    T findById(ID id);

    /**
     * 绑定模型中的基础属性：创建人、创建时间、修改人、修改时间
     * @param entity 要保存或修改的实体
     */
    void bindModelWithBaseProperty(T entity);

    /**
     * 逻辑删除
     * @param entity
     * @param delReason
     * @return
     */
    T deleteByStatus(T entity,String delReason);

    /**
     * 根据id逻辑删除
     * @param id
     * @param delReason
     * @return
     */
    T deleteByStatus(ID id,String delReason);

    /**
     * 根据id查找，没有逻辑删除
     * @param id
     * @return
     */
    T findByIdAndNotDelete(String id);

    /**
     * 获取数据库时间
     * @return
     */
    Date getCurrentDate();
}
