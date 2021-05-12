package com.util.exception;

/**
 * TODO
 * 全局异常类
 * @author cxh
 * @date 2021/5/7 11:01
 */
public class GlobalException extends RuntimeException{

    private ErrorCodeEnum errorCode;

    public GlobalException(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }
}
