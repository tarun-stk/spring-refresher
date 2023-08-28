package com.stk.aopdemo.aspect;

import com.stk.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-23)
public class MyDemoLoggingAspectClass {

    //    Creating advice for after
//    About after
//    After runs no matter what if exception occurs or not same like finally block
//    mostly used to do clean up stuff, close resources post executing a method
    @After("execution(* com.stk.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        //        getting the method signature
        String method = theJoinPoint.getSignature().toShortString();
//        printing the method sig
        System.out.println("In @After (finally) advice on method: " + method);

    }

}
