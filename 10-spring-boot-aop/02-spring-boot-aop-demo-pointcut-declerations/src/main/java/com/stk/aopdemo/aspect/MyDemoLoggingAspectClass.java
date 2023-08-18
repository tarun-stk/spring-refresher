package com.stk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspectClass {

//    Main purpose of @Pointcut is to re-use the pointcut expression
//    write expression at one place and use that methodname to trigger advice
//    if in future you wnat to change the expression, you can simply change at one position
    @Pointcut("execution(public void addAccount())")
    public void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n===>>> Performing APi analytics");
    }

//    output
//    ===>>> Executing @Before advice on addAccount()
//
//===>>> Performing APi analytics
//class com.stk.aopdemo.dao.AccountDAOImpl: DOING MY DB WORK: ADDING AN ACCOUNT
//
//===>>> Executing @Before advice on addAccount()
//
//===>>> Performing APi analytics
//class com.stk.aopdemo.dao.MembershipDAOImpl: DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT
}
