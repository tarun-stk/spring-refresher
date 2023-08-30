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
//     Be very careful when handling exception in @Around advice type, use it only on basis of requirement
//    because caller(main in this case) never knows that exception occured,
//    because it was handled in @Around advice and gave a default response.

    @Around("execution(* com.stk.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

//        getting the method signature
        String method = theProceedingJoinPoint.getSignature().toShortString();
//        printing the method sig
        System.out.println("In @Around advice on method: " + method);

//        begin timestamp
        long begin = System.currentTimeMillis();

//        call the method
        Object result = null;

        try{
            result = theProceedingJoinPoint.proceed();
        }
        catch (Exception ex){
//            /log the exception
            System.out.println("Exception occured in TrafficFortuneService(): " + ex.getMessage());
//            return custom fortune
            return "Exception? no worries AOP gave you a default helicopter (response)";
        }

//        end timestamp
        long end = System.currentTimeMillis();

//        calculate duration
        long duration = end-begin;
        System.out.println("\nIn @Around advice type method call took duration of: " + (duration/1000.0));

//        return result
        return result;

    }

}
