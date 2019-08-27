package com.sp.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspectj {
    public void before(){
        System.out.println("前置通知");
    }
    public void afterReturning(){
        System.out.println("后置返回通知");
    }
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知");
        Object result = pjp.proceed();
        System.out.println("环绕结束");
        return result;
    }
    public void except(){
        System.out.println("异常通知");
    }
    public void after(){
        System.out.println("最终通知");
    }
}
