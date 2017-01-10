package com.coderbike.web.controller;

import com.coderbike.common.constant.CommonConstant;
import com.coderbike.common.context.UserContext;
import com.coderbike.core.controller.AbstractController;
import com.coderbike.entity.passport.LocalAuth;
import com.coderbike.entity.user.User;
import com.coderbike.http.ResponseVo;
import com.coderbike.service.LocalAuthService;
import com.coderbike.service.UserService;
import com.coderbike.service.utils.AuthenCookieUtils;
import com.coderbike.utils.IAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/13 10:38
 */
@Controller
@RequestMapping("passport")
public class PassportController extends AbstractController {

    @Value("${authSecret}")
    private String authSecret;

    @Autowired
    private UserService userService;

    @Autowired
    private LocalAuthService localAuthService;

    @RequestMapping("/login")
    public ModelAndView loginUI() {
        return new ModelAndView("passport/login");
    }

    /**
     * <p>登录<p/>
     * author: liubingguang
     * date: 2016/12/13 15:54
     */
    @RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo login(@RequestParam String username, @RequestParam String password) {
        IAssert.notBlank(username, "用户名或密码错误");
        IAssert.notBlank(password, "用户名或密码错误");

        User user = userService.findByUsernameAndPwd(username, password);
        IAssert.notNull(user, "用户名或密码错误");

        request.getSession().setAttribute(CommonConstant.SESSION_USER, user.getId());

        UserContext.bindUser(user);
        LocalAuth localAuth = localAuthService.findByUserId(user.getId());
        AuthenCookieUtils.addAuthCookie(user.getId(), localAuth.getPassword(), authSecret);

        ResponseVo responseVo = new ResponseVo();
        responseVo.success("登录成功", user);
        return responseVo;
    }

    /**
     * <p>注册<p/>
     * author: liubingguang
     * date: 2016/12/13 15:55
     */
    @RequestMapping("/registerSubmit")
    @ResponseBody
    public ResponseVo register(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String repassword) {

        IAssert.notBlank(username, "用户名不能为空");
        IAssert.notBlank(password, "密码不能为空");
        IAssert.notBlank(repassword, "重复密码不能为空");
        IAssert.isTrue(password.equals(repassword), "两次密码不一致");

        User user = new User();
        user.setUsername(username);
        user = userService.register(user, password);

        // reset login cookie
        LocalAuth localAuth = localAuthService.findByUserId(user.getId());
        AuthenCookieUtils.addAuthCookie(user.getId(), localAuth.getPassword(), authSecret);

        return new ResponseVo();
    }

    @RequestMapping("register")
    public ModelAndView registerUI() {
        return new ModelAndView("passport/register");
    }
}
