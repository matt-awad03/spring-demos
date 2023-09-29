package com.matthewa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAspect {
    @Before(value = "execution(* com.matthewa.aop..*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Before UserService Aspect >>>>>>");
    }

    @After(value = "execution(* com.matthewa.aop..*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After UserService Aspect >>>>>>");
    }

    @AfterReturning(value = "execution(* com.matthewa.aop..*(..))")
    public void afterReturningAdvice(JoinPoint joinPoint) {
        System.out.println("AfterReturning UserService Aspect >>>>>>");
    }

    @Around(value = "execution(* com.matthewa.aop..*(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("Around UserService Aspect >>>>>>");
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Exception occurred " + e);
        }
    }
}
