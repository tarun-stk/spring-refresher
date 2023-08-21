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
    @Pointcut("execution(* com.stk.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

//    createa pointcut for setters
    @Pointcut("execution(public void com.stk.aopdemo.dao.*.set*(..))")
    public void setter(){}

//    createa pointcut for getters
    @Pointcut("execution(* com.stk.aopdemo.dao.*.get*(..))")
    public void getter(){}

//    create pointcut for include package and exclude setter & getter.
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void includeDaoPackageAndExcludeSetterAndGetter(){}

    @Before("includeDaoPackageAndExcludeSetterAndGetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }


//    output

//===>>> Executing @Before advice on addAccount()
//    class com.stk.aopdemo.dao.AccountDAOImpl: DOING MY DB WORK: ADDING AN ACCOUNT
//    class com.stk.aopdemo.dao.AccountDAOImpl: setting level setLevel()
//    class com.stk.aopdemo.dao.AccountDAOImpl: setting Name setName()
//    class com.stk.aopdemo.dao.AccountDAOImpl: getting level getLevel()
//    class com.stk.aopdemo.dao.AccountDAOImpl: getting Name getName()
//
//===>>> Executing @Before advice on addAccount()
//    class com.stk.aopdemo.dao.MembershipDAOImpl: DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT
}
