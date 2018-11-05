package com.nana.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all f our related advices for logging

    // let's start with an @Before advice

    //@Before("execution(public void testAccount())")
    //@Before("execution(* void com.nana.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(* void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(com.nana.aopdemo.Account))")
    //@Before("execution(* add*(com.nana.aopdemo.Account, ..))")
    @Before("execution(* com.nana.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>>>>>> Executing @Before advice on addAccount()");
    }

}
