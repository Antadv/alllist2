package com.coderbike.core.jpa;

import com.coderbike.core.entity.BaseEntity;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/27 12:02
 */
public abstract class GenericJpaDaoImpl<T extends BaseEntity, ID extends Serializable>
        extends SimpleJpaRepository<T, ID>
        implements GenericJpaDao<T, ID>  {

    @PersistenceContext
    private final EntityManager em;

    private final JpaEntityInformation<T, ID> entityInformation;

    // private Class<M> entityClass;
    private String entityName;
    private String idName;

    public GenericJpaDaoImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        // this.entityClass = this.entityInformation.getJavaType();
        this.entityName = this.entityInformation.getEntityName();
        this.idName = this.entityInformation.getIdAttributeNames().iterator().next();
        this.em = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public <S extends T> S save(S entity) {
        Assert.notNull(entity, "entity不能为空");
        Date date = new Date();
        if (entity.getId() == null) {
            entity.setFirstTime(date);
        }
        entity.setLastTime(date);
        return super.save(entity);
    }
}
