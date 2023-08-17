package com.stk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspectClass {

//  Now this advice will trigger on all methods which have method names starting with add & also
//  regardless of return type -> on all kind of different return types..
    @Before("execution(public * add*())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }

//    output:
//    ===>>> Executing @Before advice on addAccount()
//    class com.stk.aopdemo.dao.AccountDAOImpl: DOING MY DB WORK: ADDING AN ACCOUNT
//
//    ===>>> Executing @Before advice on addAccount()
//    class com.stk.aopdemo.dao.MembershipDAOImpl: DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT
}
