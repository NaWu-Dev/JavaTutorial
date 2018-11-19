package com.nana.practice.flightreservation.repository;

import com.nana.practice.flightreservation.entities.Passenger;
import com.nana.practice.flightreservation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
