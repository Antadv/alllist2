package com.coderbike.utils;

import com.coderbike.core.entity.BaseEntity;
import com.coderbike.exception.AuthenException;
import com.coderbike.exception.GeneralException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

/**
 * <p>
 *     自定义断言
 *     如果想客户端输出自定义异常，使用该断言
 *     否则使用org.springframework.util.Assert
 * <p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/13 16:23
 */
public class IAssert extends Assert {

    private IAssert() {
    }

    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new GeneralException(message);
        }
    }

    public static void notBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new GeneralException(message);
        }
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new GeneralException(message);
        }
    }

    /**
     * <p>认证校验<p/>
     * author: imant
     * date: 2016/12/13 16:59
     */
    public static <T extends BaseEntity> void authenticate(T entity, String message) {
        if (entity == null) {
            throw new AuthenException(message);
        }
    }
}
