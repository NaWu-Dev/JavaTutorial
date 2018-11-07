package com.nana.aopdemo.aspect;

import com.nana.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.nana.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n\n====>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = theProceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("====>>> Duration: " + duration / 1000 + " seconds" );

        return result;

    }


    @After("execution(* com.nana.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint theJoinPoint) {

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n\n@AFter: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.nana.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theException"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theException) {

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println("\n\n" + method + "====== @AFterThrowing exception: " + theException);

    }

    // Add a new advice for @AfterReturning on the findAccoutns method
    @AfterReturning(
            pointcut ="execution(* com.nana.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n-------------> Executing @AfterReturning on method: " + method);

        System.out.println("\n-------------> result is: " + result);

        // post-process the data... modify return data
        // convert the account name to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n-------------> result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts and update name to UpperCase
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }

    }

    @Before("com.nana.aopdemo.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n==========>>>>>>> Executing @Before advice on addAccount()");

        // display method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method:" + methodSignature);

        // display method argument

        // get the arguments
        Object[] args = theJoinPoint.getArgs();

        // loop the arguments and print out
        for (Object tempArg : args){
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account level: " + theAccount.getLevel());
            }
        }

    }

}
