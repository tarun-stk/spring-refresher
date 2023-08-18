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

//    Decoding the pointcut expression
//    execution(* com.stk.aopdemo.dao.*.*(..))
//    * -> match any return type
//    com.stk.aopdemo.dao -> match this package
//    .* -> match all classes in above package
//    .*(..) -> match all methods irrespective of name and number of params.
    @Before("execution(* com.stk.aopdemo.dao.*.*(..))")
    public void beforeAdd(){
        System.out.println("\n====>> Executing beforeAdd() advice.");
    }

//    output:
//    ====>> Executing beforeAdd() advice.
    //class com.stk.aopdemo.dao.AccountDAOImpl: DOING MY DB WORK: ADDING AN ACCOUNT
    //
    //====>> Executing beforeAdd() advice.
    //class com.stk.aopdemo.dao.AccountDAOImpl: DOING MY DB WORK: DOING MY WORK
    //
    //====>> Executing beforeAdd() advice.
    //class com.stk.aopdemo.dao.MembershipDAOImpl: DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT
    //
    //====>> Executing beforeAdd() advice.
    //class com.stk.aopdemo.dao.MembershipDAOImpl I'm going to sleep..

}
