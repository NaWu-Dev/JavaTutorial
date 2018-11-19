package com.nana.practice.flightreservation.controller;

import com.nana.practice.flightreservation.entities.Flight;
import com.nana.practice.flightreservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("findFlights")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate,
                              ModelMap modelMap) {

        String test = departureDate.toString();
        List<Flight> flights = flightRepository.findFlight(from, to, departureDate);
        modelMap.addAttribute("flights", flights);

        return "displayFlights";
    }


}
