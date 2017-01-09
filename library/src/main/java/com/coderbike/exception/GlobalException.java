package com.coderbike.exception;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/13 16:35
 */
public class GlobalException extends RuntimeException {

    public GlobalException() {
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalException(Throwable cause) {
        super(cause);
    }
}
