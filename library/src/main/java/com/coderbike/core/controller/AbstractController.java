package com.coderbike.core.controller;

import com.coderbike.core.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/14 15:52
 */
public class AbstractController<T extends BaseEntity> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    /**
     * restful get /api/id
     *
     * 没用@ResposeBody, 考虑到查询后可能会跳转
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    protected Object get(@PathVariable("id") Long id) {
        return null;
    }

    /**
     * restful post /api
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    protected Object add(@RequestBody T t) {
        return null;
    }

    /**
     * restful put /api
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    protected Object update(@RequestBody T t) {
        return null;
    }

    /**
     * restful delete /api/id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    protected Object delete(@PathVariable("id") Long id) {
        return null;
    }
}
