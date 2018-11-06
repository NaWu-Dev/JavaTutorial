package com.nana.aopdemo;

import com.nana.aopdemo.dao.AccountDAO;
import com.nana.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] arg) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Calling getFortune");
        String data = theFortuneService.getFortune();
        System.out.println("My fortune is: " + data);

        // close the context
        context.close();

    }

}
