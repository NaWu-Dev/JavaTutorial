package com.nana.flightcheckin.controllers;

import com.nana.flightcheckin.integration.ReservationRestClient;
import com.nana.flightcheckin.integration.dto.Reservation;
import com.nana.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    @Autowired
    private ReservationRestClient restClient;

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/showStartCheckin")
    public String showStartCheckin() {
        return "startCheckin";
    }

    @RequestMapping("/startCheckin")
    public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {

        Reservation reservation = restClient.findReservation(reservationId);
        modelMap.addAttribute("reservation", reservation);

        return "displayReservationDetail";

    }

    @RequestMapping("/completeCheckin")
    public String completeCheckin(@RequestParam("reservationId") Long reservationId, @RequestParam("numberOfBags") int numberOfBags) {

        ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
        reservationUpdateRequest.setId(reservationId);
        reservationUpdateRequest.setCheckedIn(true);
        reservationUpdateRequest.setNumberOfBags(numberOfBags);
        restClient.updateReservation(reservationUpdateRequest);

        return "checkInConfirmation";
    }

}
