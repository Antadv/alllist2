package com.coderbike.web.quartz;

import com.coderbike.entity.user.User;
import com.coderbike.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * <p>用户相关定时任务<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/1/4 18:01
 */
@Component
public class UserQuartz {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserQuartz.class);

    @Autowired
    private UserService userService;

    /**
     * <p>定时查找用户数量<p/>
     * author: imant
     * date: 2017/1/4 18:08
     */
    @Scheduled(cron = "0/20 * * * * *")
    public void sayHi() {
        List<User> userList = userService.findAll();
        LOGGER.info("@Scheduled --- " + userList.size());
    }

    /**
     * <p>测试<p/>
     * author: imant
     * date: 2017/1/4 18:12
     */
    @Scheduled(cron = "0/2 * * * * *")
    public void test() {
        System.out.println("current time: " + new Date());
    }
}
