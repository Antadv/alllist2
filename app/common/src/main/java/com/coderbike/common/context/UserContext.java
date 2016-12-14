package com.coderbike.common.context;

import com.coderbike.entity.user.User;

/**
 * <p>获取当前用户<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/12 16:11
 */
public class UserContext implements AutoCloseable {

    private static ThreadLocal<User> current = new ThreadLocal<User>();

    public UserContext(User user) {
        current.set(user);
    }

    public static void bindUser(User user) {
        current.set(user);
    }

    public static User getCurrentUser() {
        return current.get();
    }

    /**
     * close source automatically
     * @since 1.7
     */
    @Override
    public void close() throws Exception {
        current.remove();
    }
}
