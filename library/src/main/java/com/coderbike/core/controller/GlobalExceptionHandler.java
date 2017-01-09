package com.coderbike.core.controller;

import com.coderbike.exception.AuthenException;
import com.coderbike.exception.GlobalException;
import com.coderbike.http.ResponseVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>全局异常处理类<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/13 16:19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 404
    // private static final String NOT_FOUND_ERROR = "";
    // 500
    // private static final String INTERNAL_SERVER_ERROR = "";

    /**
     * <p>处理404错误<p/>
     * author: imant
     * date: 2016/11/21 10:39
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    //@ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView notFoundErrorHandler(HttpServletRequest req, Exception e) {
        return new ModelAndView("error/404");
    }

    /**
     * <p>通用异常，输出自定义msg到客户端<p/>
     * author: imant
     * date: 2016/11/21 11:00
     */
    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo generalExpHandler(HttpServletRequest req, Exception e) {
        LOGGER.error(e.getMessage(), e);
        return new ResponseVo(ResponseVo.FATAL_CODE, e.getMessage());
    }

    /**
     * <p>认证异常</p>
     * @author imant
     * @date 2016-11-24 下午4:53:28
     */
    @ExceptionHandler(AuthenException.class)
    //@ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView authenExpHandler(HttpServletRequest req, Exception e) {
        LOGGER.error(e.getMessage(), e);
        ModelAndView model = new ModelAndView("passport/login");

        // append parameter
        StringBuilder builder = new StringBuilder();
        builder.append(req.getRequestURI());
        String queryParams = req.getQueryString();
        if (StringUtils.isNoneBlank(queryParams)) {
            builder.append("?").append(queryParams);
        }

        // replace contextPath with blank char
        String rebackurl = builder.toString().replace(req.getContextPath(), "");
        model.addObject("rebackurl", rebackurl);
        return model;
    }

    /**
     * <p>500内部错误<p/>
     * author: imant
     * date: 2016/11/21 13:04
     */
    @ExceptionHandler(Exception.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView internalErrorHandler(HttpServletRequest req, Exception e) {
        LOGGER.error(e.getMessage(), e);
        return new ModelAndView("error/500");
    }

}