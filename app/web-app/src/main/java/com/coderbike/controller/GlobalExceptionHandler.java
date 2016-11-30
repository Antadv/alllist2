package com.coderbike.controller;

import com.coderbike.exception.AuthenException;
import com.coderbike.exception.AuthoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>controller 全局异常处理类<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/11/21 10:35
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    // 404
    private static final String NOT_FOUND_ERROR = "";
    // 500
    private static final String INTERNAL_SERVER_ERROR = "";


    /**
     * <p>处理404错误<p/>
     * author: imant
     * date: 2016/11/21 10:39
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView notFoundErrorHandler(HttpServletRequest req, Exception e) {
        return new ModelAndView("error/404");
    }

    /**
     * <p>认证异常<p/>
     * author: imant
     * date: 2016/11/21 11:00
     */
    @ExceptionHandler(AuthenException.class)
    public ModelAndView autheErrorHandler(HttpServletRequest req, Exception e) {
        return null;
    }

    /**
     * <p>授权异常<p/>
     * author: imant
     * date: 2016/11/21 11:00
     */
    @ExceptionHandler(AuthoException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView authoErrorHandler(HttpServletRequest req, Exception e) {
        return null;
    }

    /**
     * <p>500内部错误<p/>
     * author: imant
     * date: 2016/11/21 13:04
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView internalErrorHandler(HttpServletRequest req, Exception e) {
        return new ModelAndView("error/500");
    }
}
