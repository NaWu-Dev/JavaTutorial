package com.nana.flightcheckin.integration;

import com.nana.flightcheckin.integration.dto.Reservation;
import com.nana.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.web.client.RestTemplate;

public class ReservationRestClientImpl implements ReservationRestClient {

    public static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL + id, Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
        return reservation;
    }

}
