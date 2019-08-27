package com.sp.advice;

import org.springframework.aop.ThrowsAdvice;

public class Throwadvice implements ThrowsAdvice {

    private void mythrow(Exception e){
        System.out.println("异常出现" + e.getMessage());
    }

}
