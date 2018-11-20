package com.nana.practice.flightreservation.services;

import com.nana.practice.flightreservation.dto.ReservationRequest;
import com.nana.practice.flightreservation.entities.Flight;
import com.nana.practice.flightreservation.entities.Passenger;
import com.nana.practice.flightreservation.entities.Reservation;
import com.nana.practice.flightreservation.repository.FlightRepository;
import com.nana.practice.flightreservation.repository.PassengerRepository;
import com.nana.practice.flightreservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) {

        // make payment
        Long flightId = reservationRequest.getFlightId();
        Flight flight = flightRepository.findById(flightId).get();

        Passenger passenger = new Passenger();
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmail(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);

        return savedReservation;

    }
}
