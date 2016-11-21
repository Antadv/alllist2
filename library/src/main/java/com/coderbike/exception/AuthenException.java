package com.coderbike.exception;

/**
 * <p>认证异常<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/11/21 17:28
 */
public class AuthenException extends RuntimeException {

    public AuthenException() {
    }

    public AuthenException(String message) {
        super(message);
    }

    public AuthenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenException(Throwable cause) {
        super(cause);
    }
}
