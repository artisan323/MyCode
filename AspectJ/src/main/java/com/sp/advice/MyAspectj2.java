package com.sp.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectj2 {

    @Pointcut("execution(* com.sp.service.service.demo())")
    private void myPointCut(){

    }

    @Before("myPointCut()")
    public void before(){
        System.out.println("前置通知");
    }

    @AfterReturning("myPointCut()")
    public void afterReturning(){
        System.out.println("后置返回通知");
    }

    @Around("myPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知");
        Object result = pjp.proceed();
        System.out.println("环绕结束");
        return result;
    }

    @AfterThrowing("myPointCut()")
    public void except(){
        System.out.println("异常通知");
    }

    @After("myPointCut()")
    public void after(){
        System.out.println("最终通知");
    }
}
