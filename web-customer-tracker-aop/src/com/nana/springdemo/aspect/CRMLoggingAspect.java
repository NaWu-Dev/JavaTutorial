package com.nana.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    /*
    1. setup logger
    2. setup pointcut declaration
    3. add @Before advice
    4. add @AfterReturnning advice
     */

    private Logger myLogger = Logger.getLogger(getClass().getName());

    // Pointcut declaration
    @Pointcut("execution(* com.nana.springdemo.controller.*.*.(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.nana.springdemo.service.*.*.(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.nana.springdemo.dao.*.*.(..))")
    private void forDAOPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow() {
    }

}
