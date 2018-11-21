package com.nana.flightcheckin;

import com.nana.flightcheckin.integration.ReservationRestClientImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class FlightcheckinApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightcheckinApplication.class, args);
    }

    @Bean
    public ReservationRestClientImpl reservationRestClient() {
        return new ReservationRestClientImpl();
    }
}
