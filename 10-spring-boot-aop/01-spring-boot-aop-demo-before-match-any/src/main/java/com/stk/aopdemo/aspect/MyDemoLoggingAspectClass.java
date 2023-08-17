package com.stk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspectClass {

//    This is where we add all our related advices for logging

//    let's start with an @Before advice

//    "execution(public void addAccount())"  -> pointcut expression
//    way of writing pointcut expressions
//    execution(modifier-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(params) throws-pattern?)
//    in the above whichever is ending with * is optional, like modifier, throws & declaring-type
//    can be omitted in the actual expression
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }

}
