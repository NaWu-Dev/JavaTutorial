package com.nana.practice.flightreservation.services;

import com.nana.practice.flightreservation.dto.ReservationRequest;
import com.nana.practice.flightreservation.entities.Flight;
import com.nana.practice.flightreservation.entities.Passenger;
import com.nana.practice.flightreservation.entities.Reservation;
import com.nana.practice.flightreservation.repository.FlightRepository;
import com.nana.practice.flightreservation.repository.PassengerRepository;
import com.nana.practice.flightreservation.repository.ReservationRepository;
import com.nana.practice.flightreservation.util.EmailUtil;
import com.nana.practice.flightreservation.util.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;


@Service
public class ReservationServiceImpl implements ReservationService {

    @Value("${com.nana.practice.flightreservation.itinerary.dirpath}")
    private String ITINERARY_DIR;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;

    private final static Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Override
    public Reservation bookFlight(ReservationRequest reservationRequest) {

        LOGGER.info("Inside bookFlight()");

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
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);

        String filePath = ITINERARY_DIR +
                savedReservation.getId() + ".pdf";
        pdfGenerator.generateItinerary(savedReservation, filePath);
        emailUtil.sendItinerary(passenger.getEmail(), filePath);

        return savedReservation;

    }
}
