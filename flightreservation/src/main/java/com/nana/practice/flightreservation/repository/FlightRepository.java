package com.nana.practice.flightreservation.repository;

import com.nana.practice.flightreservation.entities.Flight;
import com.nana.practice.flightreservation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
