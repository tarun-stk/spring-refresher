package com.stk.aopdemo.aspect;

import com.stk.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-23)
public class MyDemoLoggingAspectClass {

//    Creating advice for Around
//    Around advice type runs before and after the method call
//    It takes param as ProceedingJoinPoint using which we proceed for the method call using proceed() method
//    Using this advice we can track how long does the method is executing, etc.,
    @Around("execution(* com.stk.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

//        getting the method signature
        String method = theProceedingJoinPoint.getSignature().toShortString();
//        printing the method sig
        System.out.println("In @Around advice on method: " + method);

//        begin timestamp
        long begin = System.currentTimeMillis();

//        call the method
        Object result = theProceedingJoinPoint.proceed();

//        end timestamp
        long end = System.currentTimeMillis();

//        calculate duration
        long duration = end-begin;
        System.out.println("\nIn @Around advice type method call took duration of: " + (duration/1000.0));

//        return result
        return result;

    }

}
