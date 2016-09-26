package com.coderbike.core.service;


import com.coderbike.core.entity.BaseEntity;
import com.coderbike.core.jpa.GenericJpaDao;
import com.coderbike.core.mybatis.GenericMybatisDao;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 17:30
 */
public abstract class GenericServiceImpl<T extends BaseEntity,
                                        ID extends Serializable,
                                        JpaDao extends GenericJpaDao<T, ID>,
                                        MybatisDao extends GenericMybatisDao<T, ID>>
        extends SimpleJpaRepository<T, ID>
        implements GenericService<T, ID, JpaDao, MybatisDao> {

    @PersistenceContext
    private EntityManager em;

    private JpaEntityInformation<T, ID> entityInformation;

    private String entityName;
    private String idName;

    public GenericServiceImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityName = this.entityInformation.getEntityName();
        this.idName = this.entityInformation.getIdAttributeNames().iterator().next();
        this.em = entityManager;
    }

    @Resource
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public <S extends T> S save(S entity) {
        Assert.notNull(entity, "保存的实体不能为空");
        Date date = new Date();
        if (entity.getId() == null) {
            entity.setFirstTime(date);
        }
        entity.setLastTime(date);
        return super.save(entity);
    }

    public T findByIdNotDelete(ID id) {
        return getJpaDao().findByIdNotDelete(id);
    }
}
