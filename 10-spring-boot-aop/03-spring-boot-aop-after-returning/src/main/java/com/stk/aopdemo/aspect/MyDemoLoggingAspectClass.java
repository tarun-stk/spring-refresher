package com.stk.aopdemo.aspect;

import com.stk.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-23)
public class MyDemoLoggingAspectClass {

//    Create advice for afterreturning
    @AfterReturning(
            pointcut = "execution(* com.stk.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
//    NOTE: the name of variable in returning and method params must match
//    like shown above (returning = "result" in @AfterReturning anno && List<Account> result in params)
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
//        getting the method signature
        String method = theJoinPoint.getSignature().toShortString();
//        printing the method sig
        System.out.println("In @AfterReturning advice on method: " + method);

//        getting the result
        System.out.println("\n result===>: " + result);

//        Let's post process the data, let's modify the result
//        Be very careful while doing post processing
//        because it will actually modify the actual result set to caller function also
        convertNamesToUpperCase(result);
        System.out.println("\n after modifying the result in @AfterReturning advice ===>: " + result);

    }

    private void convertNamesToUpperCase(List<Account> result) {

//        loop through the result
        for(Account tempAccount: result){
            //        convert names to upper case
            String upperName = tempAccount.getName().toUpperCase();

            //        assign uppercase to the result set
            tempAccount.setName(upperName);
        }
    }

}
