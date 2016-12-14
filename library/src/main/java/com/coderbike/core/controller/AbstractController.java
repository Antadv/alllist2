package com.coderbike.core.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/14 15:52
 */
public class AbstractController {

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
}
