package com.nana.practice.flightreservation.controller;

import com.nana.practice.flightreservation.dto.ReservationRequest;
import com.nana.practice.flightreservation.entities.Flight;
import com.nana.practice.flightreservation.entities.Reservation;
import com.nana.practice.flightreservation.repository.FlightRepository;
import com.nana.practice.flightreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    @GetMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {

        Flight flight = flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight", flight);

        return "completeReservation";
    }

    @PostMapping("/completeReservation")
    public String completeReservation(ReservationRequest reservationRequest, ModelMap modelMap) {

        Reservation reservation = reservationService.bookFlight(reservationRequest);
        modelMap.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());

        return "reservationConfirmation";
    }

}
