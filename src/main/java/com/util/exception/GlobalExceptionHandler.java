package com.util.exception;

import com.system.dao.IExceptionDao;
import com.system.entity.ExceptionEntity;
import com.util.ResultUtil;
import com.util.UUIDtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * TODO
 *  全局异常处理
 * @author cxh
 * @date 2021/5/7 11:06
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private IExceptionDao exceptionDao;
    //捕捉到的异常
    @ExceptionHandler(value = GlobalException.class)
    public Object handleServiceException(GlobalException exception) {
        ErrorCodeEnum errorCode = exception.getErrorCode();
        ExceptionEntity ex=new ExceptionEntity();
        ex.setCode(errorCode.getCode()+"");
        ex.setId(UUIDtils.uuId());
        ex.setException(errorCode.getMsg());
        ex.setCreator("admin");
        List<ExceptionEntity> exceptionEntityList= Collections.emptyList();
        exceptionEntityList.add(ex);
        exceptionDao.batchInsert(exceptionEntityList);
        return ResultUtil.failedWithMsg(errorCode.getMsg());
    }

    //其他异常
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Object hadleServerException(Exception exception) {
        List<ExceptionEntity> exceptionEntityList= Collections.emptyList();
        exception.printStackTrace();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        String msg = "server error, please try again later";
        Class exceptionClazz = exception.getClass();
        if ( Objects.equals(MissingServletRequestParameterException.class, exceptionClazz)) {
            msg = "incorrect parameter";
            httpStatus = HttpStatus.BAD_REQUEST;
        } else if (Objects.equals(HttpRequestMethodNotSupportedException.class, exceptionClazz)) {
            httpStatus = HttpStatus.BAD_REQUEST;
            msg = exception.getMessage();
        }
        ExceptionEntity ex=new ExceptionEntity();
        ex.setCode(HttpStatus.BAD_REQUEST+"");
        ex.setId(UUIDtils.uuId());
        ex.setException( exception.getMessage());
        ex.setCreator("admin");
        exceptionEntityList.add(ex);
        exceptionDao.batchInsert(exceptionEntityList);
        return ResultUtil.failedWithMsg(msg);
    }
}
