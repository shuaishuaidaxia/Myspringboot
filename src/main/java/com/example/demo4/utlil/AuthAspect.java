package com.example.demo4.utlil;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/*切面*/
@Aspect
@Component
public class AuthAspect {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* com.example.demo4.Controller.AopController.*(..))")
    public Object aspectHandlerMethod(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("aaaaaaaaaa");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("aaaaa", request);
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        logger.info("aa",method);

        return pjp.proceed();
    }
}
