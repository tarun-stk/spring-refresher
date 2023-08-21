package com.stk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class MyApiAnalyticsAspect {

    //Always use fully qualified names
    @Before("com.stk.aopdemo.aspect.PointCutDeclerations.forDaoPackageNoGetterSetter()")
    public void performApiAnalyticsAdvice(){
        System.out.println("\n====> @Before in performApiAnalytics()");
    };
}
