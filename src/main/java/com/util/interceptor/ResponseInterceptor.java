package com.util.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author cxh
 * @date 2021/4/30 14:13
 */
@Aspect
@Component
@Slf4j
public class ResponseInterceptor {

//    @Before(value = "@annotation(com.util.interceptor.ValidateParam)")
//    public Object processValidation(JoinPoint pjp){
//        try {
//            return pjp.proceed();
//        }catch (Throwable e)
//        {
//            log.error("错误信息：",e);
//        }
//        return null;
//    }
}
