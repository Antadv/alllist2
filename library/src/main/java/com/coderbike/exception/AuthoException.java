package com.coderbike.exception;

/**
 * <p>授权异常<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/11/21 17:29
 */
public class AuthoException extends RuntimeException {

    public AuthoException() {
    }

    public AuthoException(String message) {
        super(message);
    }

    public AuthoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthoException(Throwable cause) {
        super(cause);
    }
}
