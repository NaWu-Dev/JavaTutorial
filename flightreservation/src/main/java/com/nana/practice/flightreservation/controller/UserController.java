package com.nana.practice.flightreservation.controller;

import com.nana.practice.flightreservation.entities.User;
import com.nana.practice.flightreservation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("/showReg")
    public String showRegistrationPage() {

        LOGGER.info("Inside showRegistrationPage()");
        return "login/registerUser";

    }

    @PostMapping("/registerUser")
    public String register(@ModelAttribute("user") User user) {

        LOGGER.info("Inside register()" + user);
        // encode password before saving
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login/login";

    }

    @GetMapping("/showLogin")
    public String login() {
        return "/login/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {

        LOGGER.error("ERROR");
        LOGGER.warn("WARN");
        LOGGER.info("INFO");
        LOGGER.debug("DEBUG");
        LOGGER.trace("TRACE");
        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(password)) {
            return "findFlights";
        } else {
            modelMap.addAttribute("msg", "Invalid Username or Password. Please try again. ");
        }
        return "login/login";

    }

}
