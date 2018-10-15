package com.na.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] arg) {

        // read spring config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        SwimCoach myCoach = context.getBean("swimCoach", SwimCoach.class);

        // call a method on the bean
        System.out.println(myCoach.getDailyWorkout());

        // call method to get daily fortune
        System.out.println(myCoach.getDailyFortune());

        // call the email and team
        System.out.println(myCoach.getEmail());

        System.out.print(myCoach.getTeam());

        // close context
        context.close();

    }

}
