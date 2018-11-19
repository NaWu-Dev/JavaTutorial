package com.nana.practice.flightreservation.controller;

import com.nana.practice.flightreservation.entities.User;
import com.nana.practice.flightreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/showReg")
    public String showRegistrationPage() {

        return "login/registerUser";

    }

    @PostMapping("/registerUser")
    public String register(@ModelAttribute("user") User user) {

        userRepository.save(user);
        return "login/login";

    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {

        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(password)) {
            return "findFlights";
        } else {
            modelMap.addAttribute("msg", "Invalid Username or Password. Please try again. ");
        }
        return "login/login";

    }

}
