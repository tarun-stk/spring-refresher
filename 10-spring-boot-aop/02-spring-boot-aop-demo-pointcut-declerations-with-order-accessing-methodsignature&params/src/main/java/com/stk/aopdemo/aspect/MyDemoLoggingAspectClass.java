package com.stk.aopdemo.aspect;

import com.stk.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-23)
public class MyDemoLoggingAspectClass {



//Always use fully qualified names
    @Before("com.stk.aopdemo.aspect.PointCutDeclerations.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n===>>> Executing @Before advice on addAccount()");

//        display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method signature: " + methodSignature);

//        display method arguments
        Object[] args = theJoinPoint.getArgs();
        for(Object obj: args){
            System.out.println(obj);
            if(obj instanceof Account){
                Account theAccout = (Account) obj;
                System.out.println("Name of account: " + theAccout.getName());
                System.out.println("Level of account: " + theAccout.getLevel());
            }
        }

    }

}
