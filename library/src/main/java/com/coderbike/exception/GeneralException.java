package com.coderbike.exception;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2016/12/13 16:35
 */
public class GeneralException extends RuntimeException {

    public GeneralException() {
    }

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralException(Throwable cause) {
        super(cause);
    }
}
