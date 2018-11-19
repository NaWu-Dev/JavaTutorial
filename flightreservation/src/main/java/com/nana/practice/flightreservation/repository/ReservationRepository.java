package com.nana.practice.flightreservation.repository;

import com.nana.practice.flightreservation.entities.Reservation;
import com.nana.practice.flightreservation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
