package com.nana.practice.flightreservation.controller;

import com.nana.practice.flightreservation.entities.Flight;
import com.nana.practice.flightreservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @GetMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {

        Flight flight = flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight", flight);

        return "completeReservation";
    }

}
