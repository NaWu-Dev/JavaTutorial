package com.nana.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all f our related advices for logging

    // let's start with an @Before advice

    @Pointcut("execution(* com.nana.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    // create pointcut for getter method
    @Pointcut("execution(* com.nana.aopdemo.dao.*.get*(..))")
    private void getter(){}

    // create pointcut for setter method
    @Pointcut("execution(* com.nana.aopdemo.dao.*.set*(..))")
    private void setter(){}

    // create pointcut : include package ... exclude getter / setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>>>>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n==========>>>>>>> Perform API Analytics");
    }

}
