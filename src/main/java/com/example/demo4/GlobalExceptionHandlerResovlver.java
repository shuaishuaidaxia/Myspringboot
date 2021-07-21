package com.example.demo4;

import com.example.demo4.exceptions.ParamsException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 */
@ControllerAdvice //作为全局异常处理的切面类 交给ioc容器处理
public class GlobalExceptionHandlerResovlver {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String,Object> exceptionHanderl(Exception e)
    {
        Map<String,Object> map=new HashMap<>();
        map.put("code",500);
        map.put("msg","系统异常!");
//        if (e instanceof ParamsException)
//        {
//            ParamsException p= (ParamsException) e;
//            map.put("code",p.getCode());
//            map.put("msg",p.getMsg());
//        }
        e.printStackTrace();
        return  map;
    }
    /**
     * 处理特定异常 如自己的异常类
     *
     */
    @ExceptionHandler(value = ParamsException.class)
    @ResponseBody
    public Map<String,Object> exceptionHanderl02(ParamsException p)
    {
        Map<String,Object> map=new HashMap<>();
        map.put("code",p.getCode());
        map.put("msg",p.getMsg());
        return map;
    }
    /**
     * 处理数据校验异常
     *
     */
    @ExceptionHandler(value = org.springframework.validation.BindException.class)
    @ResponseBody
    public Map<String,Object> exceptionHanderl03(BindException b)
    {
        Map<String,Object> map=new HashMap<>();
        map.put("code",500);
        map.put("msg",b.getBindingResult().getFieldError().getDefaultMessage());
        return map;
    }
}
