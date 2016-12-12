package com.coderbike.utils.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>spring 获取bean工具类<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 16:53
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext == null) {
            throw new IllegalArgumentException("applicationContext can't be null");
        }
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static  <T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        Map<String, T> beanMap = applicationContext.getBeansOfType(clazz);
        if (beanMap.size() == 0) {
            throw new NoSuchBeanDefinitionException("no beans of type " + clazz.getName());
        }
        if (beanMap.size() > 1) {
            throw new IllegalStateException("multiple beans of type " + clazz.getName());
        }
        return beanMap.values().iterator().next();
    }

}
