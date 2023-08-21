package com.stk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-23)
public class MyDemoLoggingAspectClass {

//    Using @Order anno:
//    Before adding this anno, spring was executing Aspects in random order
//    TO avoid this u can use @Order() anno and give precedence inside ()
//    Lowest number has the highest preecdence
//    for example Order(2) will execute after executing Order(1)
//    You can give values from Integer.MIN_VALUE to Integer.MAX_VALUE
//    You can give any value, you don;t have to follow any consecutive sequence like 1, 2, 3
//    even -34, 8, 89 is also same has 1, 2, 3 -> it just follows ascending order of sequences
//    But you are not allowed to give same number to multiple aspects then it wont run


//Always use fully qualified names
    @Before("com.stk.aopdemo.aspect.PointCutDeclerations.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n===>>> Executing @Before advice on addAccount()");
    }

}
