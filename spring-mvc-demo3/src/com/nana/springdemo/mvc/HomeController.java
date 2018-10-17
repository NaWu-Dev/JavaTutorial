package com.nana.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // add request mapping to controller method
    @RequestMapping("/")

    // define controller method
    public String showPage() {
        return "main-menu";
    }

}
