package com.helloSpring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* com.helloSpring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start : " + joinPoint.toString());
        try{
            Object result = joinPoint.proceed();
            return result;
        } finally{
            System.out.println("End : " + joinPoint.toString() + " / Time : " + (System.currentTimeMillis() - start));
        }
    }
}
