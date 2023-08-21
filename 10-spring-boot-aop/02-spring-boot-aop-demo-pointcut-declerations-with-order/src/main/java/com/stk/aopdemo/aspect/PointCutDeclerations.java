package com.stk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//When you only have @pointCut annos inside class @Aspect anno is optional
//@Aspect is only need if you're usign @Before, @After, etc. inside class
//Adding here just in case this class might include one of @Before annos
@Aspect
public class PointCutDeclerations {

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
    public void forDaoPackageNoGetterSetter(){}

}
