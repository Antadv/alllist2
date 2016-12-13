package com.coderbike.http;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/13 15:31
 */
public class ResponseVo {

    public static final String SUCESS_CODE = "200";
    public static final String FATAL_CODE = "500";

    private String code = SUCESS_CODE;
    private String message;
    private Object obj;

    public ResponseVo() {
    }

    public ResponseVo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void success(String message) {
        this.message = message;
    }

    public void success(String message, Object obj) {
        this.message = message;
        this.obj = obj;
    }

    public void fatal(String message) {
        this.code = FATAL_CODE;
        this.message = message;
    }

    public void fatal(String message, Object obj) {
        this.code = FATAL_CODE;
        this.message = message;
        this.obj = obj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
