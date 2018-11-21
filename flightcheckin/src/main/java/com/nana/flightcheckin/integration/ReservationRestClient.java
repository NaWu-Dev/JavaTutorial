package com.nana.flightcheckin.integration;

import com.nana.flightcheckin.integration.dto.Reservation;
import com.nana.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

    public Reservation findReservation(Long id);

    public Reservation updateReservation(ReservationUpdateRequest request);

}
