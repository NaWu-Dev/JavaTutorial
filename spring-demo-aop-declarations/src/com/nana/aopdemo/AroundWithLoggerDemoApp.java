package com.nana.aopdemo;

import com.nana.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] arg) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        TrafficFortuneService theFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info ("Calling getFortune");
        String data = theFortuneService.getFortune();
        myLogger.info("My fortune is: " + data);
        myLogger.info("Finished. ");

        // close the context
        context.close();

    }

}
