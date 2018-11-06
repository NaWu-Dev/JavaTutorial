package com.nana.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {

        // similate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // return a fortune
        return "Expect heavy traffic this morning";

    }

}
