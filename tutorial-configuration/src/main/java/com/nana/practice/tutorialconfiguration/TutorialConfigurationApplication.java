package com.nana.practice.tutorialconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class TutorialConfigurationApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                SpringApplication.run(TutorialConfigurationApplication.class, args);

        for (String name : applicationContext.getBeanDefinitionNames())
            System.out.println(name);

    }

    @Profile("dev")
    @Bean
    public String devBean(){return "dev";};

    @Profile("test")
    @Bean
    public String testBean(){return "test";};

    @Profile("prod")
    @Bean
    public String prodBean(){return "prod";};


}
