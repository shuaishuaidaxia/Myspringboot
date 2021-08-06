package com.example.demo4.utlil;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.PostPersist;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/*切面*/
@Aspect
@Component  //将该类交给 Spring 来管理
public class AuthAspect {

    Logger logger = LoggerFactory.getLogger(getClass());
   /* @Around("execution(* com.example.demo4.Controller.UserJpaController.*(..))")
    public Object aspectHandlerMethod(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("AOP>>>>>>>>>>>>>>");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object retobj = pjp.proceed();
        logger.info("请求地址："+request.getRequestURI());
        return retobj;
    }*/
   /* @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut() {}
    // Before表示logAdvice将在目标方法执行前执行
    @Before("logAdvicePointcut()")
    public void logAdvice(){
        // 这里只是一个示例，你可以写任何处理逻辑
        System.out.println("get请求的advice触发了");
    }*/

    // 定义一个切面，括号内写入第1步中自定义注解的路径
  /*  @Pointcut("@annotation(com.example.demo4.utlil.PermissionsAnnotation)")
    private void permissionCheck() {
    }*/

   /* @Around("permissionCheck()")*/
   /*@Around("execution(* com.example.demo4.Controller.UserJpaController.*(..))")*/

   @Pointcut("execution(* com.example.demo4.Controller..*.*(..))")
   public void pointCut() {}

    /**
     * 在上面定义的切面方法只之前执行该方法
     * @param joinPoint jointPoint
     */

    @Before("pointCut()")
    public void doBefore(JoinPoint  joinPoint) throws Throwable {
        System.out.println("===================第一个切面===================：" + System.currentTimeMillis());
        System.out.println("------------------before------------------------");
       // 获取签名
       Signature signature = joinPoint.getSignature();
       // 获取切入的包名
       String declaringTypeName = signature.getDeclaringTypeName();
       // 获取即将执行的方法名
       String funcName = signature.getName();
       logger.info("即将执行方法为: {}，属于{}包", funcName, declaringTypeName);
       ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();
       // 获取请求 URL
       String url = request.getRequestURL().toString();
       // 获取请求 IP
       String ip = request.getRemoteAddr();
       logger.info("用户请求的url为：{}，ip地址为：{}", url, ip);
        Object[] objects = joinPoint.getArgs();
        System.out.println(objects);

    }


}
