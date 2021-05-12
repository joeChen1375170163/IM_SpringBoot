package com.util.exception;

/**
 * TODO
 *
 * @author cxh
 * @date 2021/5/7 11:02
 */
public enum  ErrorCodeEnum {

    INCORRECT_PASSWORD(10001, "密码错误!"),
    INUSED_USER(10002, "账号错误!"),
    INCORRECT_MSG(10003, "验证码错误!");

    private int code;
    private String msg;

    ErrorCodeEnum (int code, java.lang.String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
