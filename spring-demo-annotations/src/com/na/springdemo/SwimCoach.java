package com.na.springdemo;


import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Value("${nana.email}")
    private String email;

    @Value("${nana.team}")
    private String team;

    @Override
    public String getDailyWorkout() {
        return "SwimCoach : Swim 1000km as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }


}
