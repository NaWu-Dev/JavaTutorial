package com.nana.practice.flightreservation.services;

import com.nana.practice.flightreservation.dto.ReservationRequest;
import com.nana.practice.flightreservation.entities.Reservation;

public interface ReservationService {

    public Reservation bookFlight(ReservationRequest reservationRequest);

}
