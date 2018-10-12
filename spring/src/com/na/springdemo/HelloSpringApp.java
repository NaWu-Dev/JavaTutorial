package com.na.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main (String[] arg) {

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoath = context.getBean("myCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoath.getDailyWorkout());

        // close the context
        context.close();
    }
}
