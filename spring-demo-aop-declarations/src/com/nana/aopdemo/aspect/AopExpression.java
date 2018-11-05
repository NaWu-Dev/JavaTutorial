package com.nana.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {

        @Pointcut("execution(* com.nana.aopdemo.dao.*.*(..))")
        public void forDaoPackage(){}

        // create pointcut for getter method
        @Pointcut("execution(* com.nana.aopdemo.dao.*.get*(..))")
        public void getter(){}

        // create pointcut for setter method
        @Pointcut("execution(* com.nana.aopdemo.dao.*.set*(..))")
        public void setter(){}

        // create pointcut : include package ... exclude getter / setter
        @Pointcut("forDaoPackage() && !(getter() || setter())")
        public void forDaoPackageNoGetterSetter(){}

}
