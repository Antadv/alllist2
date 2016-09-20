package com.coderbike.controller;

import com.coderbike.entity.User;
import com.coderbike.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/18 23:07
 */

@Controller
@RequestMapping("user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("find")
    public ModelAndView findUser() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            int i = 1/0;
            User user = userService.selectUserById(1);

            logger.info(user.getUserName() + "=============");

            modelAndView.addObject("user", user);
            modelAndView.setViewName("user/user");

            return modelAndView;
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }
}
