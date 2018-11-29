package com.nana.practice.tutorialconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeResource {

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/welcome")
    public String retrieveWelcomeMessage() {
        return welcomeMessage;
    }

    @Autowired
    private BasicConfiguration configuration;

    @RequestMapping("/dynamic-configuration")
    public Map<String, Object> dynamicConfiguration() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("key", configuration.isValue());
        return map;

    }

}
