package com.na.springdemo;

public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 3 minutes on batting practice. ";
    }

}
