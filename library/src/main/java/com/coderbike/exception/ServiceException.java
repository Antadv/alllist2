package com.coderbike.exception;

/**
 * <p>service 抛出异常<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/11/21 11:32
 */
public class ServiceException extends RuntimeException {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
