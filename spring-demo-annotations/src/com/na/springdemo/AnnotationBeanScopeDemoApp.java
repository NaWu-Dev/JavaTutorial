package com.na.springdemo;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    static public void main(String[] arg) {

        // load spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // check if they are the same
        boolean result = (theCoach == alphaCoach);

        // print out the results
        System.out.println("\nPointing to the same object: " + result);

        System.out.println("\nMemory location for theCoach: " + theCoach);

        System.out.println("\nMemory location for alphaCoach: " + alphaCoach);

        // close context
        context.close();


    }

}
