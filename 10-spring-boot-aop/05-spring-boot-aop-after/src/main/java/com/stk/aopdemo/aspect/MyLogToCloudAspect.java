package com.stk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(23)
@Component
public class MyLogToCloudAspect {

    //Always use fully qualified names
    @Before("com.stk.aopdemo.aspect.PointCutDeclerations.forDaoPackageNoGetterSetter()")
    public void logToCloudAdvice(){
        System.out.println("\n====> @Before in logToCloudAdvice()");
    };
}
