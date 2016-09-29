package com.coderbike.core.jpa;

import com.coderbike.core.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/26 16:13
 */
public interface GenericJpaDao<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {
}
