package com.stk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspectClass {

// Now this expression will call only addAccount on AccountDAO,& it will not trigger before calling
//    addAccount in membershipDao
    @Before("execution(public void com.stk.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }

}
