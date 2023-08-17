package com.stk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspectClass {

//    More on param wild cards
//    methodName() -> match with no params
//    methodName(*) -> match with one param regardless of type
//    methodName(..) -> match with 0 or more params of any type

//    Match only methods that have methodname prefixed with add
//    and accepting param as Account , Note: always give fully qualified name
    @Before("execution(public * add*(com.stk.aopdemo.Account))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }

//    output:
//      no trigger.


//    Match only methods that have methodname prefixed with add
//    and accepting param as Account, and any kind and number of params next
    @Before("execution(public * add*(com.stk.aopdemo.Account, ..))")
    public void beforeAddAccountAdvice1(){
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }

//    output
//    ===>>> Executing @Before advice on addAccount()
//class com.stk.aopdemo.dao.AccountDAOImpl: DOING MY DB WORK: ADDING AN ACCOUNT
//class com.stk.aopdemo.dao.MembershipDAOImpl: DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT

}
