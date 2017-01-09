package com.coderbike.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.coderbike.core.controller.AbstractController;
import com.coderbike.entity.user.User;
import com.coderbike.service.UserService;
import com.coderbike.utils.IAssert;
import com.coderbike.utils.RenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>测试restful<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/1/9 14:24
 */
@Controller
@RequestMapping("/rest")
public class UserRestController extends AbstractController<User> {

    @Autowired
    private UserService userService;

    /**
     * restful get /api/id
     */
    @Override
    protected Object get(@PathVariable("id") Long id) {
        IAssert.notNull(id, "id can't be null");
        User user = userService.findById(id);
        RenderUtils.rendJson(JSONObject.toJSONString(user));
        return null;
    }

    /**
     * restful post /api
     */
    @Override
    protected User add(@RequestBody User user) {
        IAssert.notNull(user, "user can't be nul");
        return userService.save(user);
    }

    /**
     * restful put /api
     */
    @Override
    protected User update(@RequestBody User user) {
        IAssert.notNull(user, "user can't be nul");
        return userService.save(user);
    }

    /**
     * restful delete /api/id
     */
    @Override
    protected Object delete(@PathVariable("id") Long id) {
        IAssert.notNull(id, "id can't be null");
        return userService.findById(id);
    }
}
