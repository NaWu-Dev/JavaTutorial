package com.nana.practice.flightreservation.controller;

import com.nana.practice.flightreservation.dto.ReservationRequest;
import com.nana.practice.flightreservation.dto.ReservationUpdateRequest;
import com.nana.practice.flightreservation.entities.Reservation;
import com.nana.practice.flightreservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationRestController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {

        return reservationRepository.findById(id).get();

    }

    @PutMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {

        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.isCheckedIn());
        Reservation updatedReservation = reservationRepository.save(reservation);

        return updatedReservation;

    }


}
