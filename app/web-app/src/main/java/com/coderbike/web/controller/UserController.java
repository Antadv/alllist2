package com.coderbike.web.controller;

import com.coderbike.core.controller.AbstractController;
import com.coderbike.entity.user.User;
import com.coderbike.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/9/18 23:07
 */

@Controller
@RequestMapping("user")
public class UserController extends AbstractController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${appid}")
    private String appid;

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("user/index");
        User user = userService.findById(1L);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("find")
    public ModelAndView findUser() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findById(1L);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/user");

        logger.info(user.getUsername());
        return modelAndView;
    }

    @RequestMapping("findAll")
    public void findAll() {
        List<User> userList = userService.findAll();
        System.out.println(userList);
    }

    @RequestMapping("test")
    public void testException() {
        Assert.notNull(null, "不能为空");
        throw new RuntimeException();
    }

    @RequestMapping("profile")
    public void testProfile() {
        System.out.println(appid);
    }

}
