package com.nana.practice.flightreservation.entities;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "res_flight")
public class Flight extends AbstractEntity{

    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;

    // Hibernate map only use Year, month, and day
    @Temporal(TemporalType.DATE)
    private Date dateOfDeparture;

    private Timestamp estimatedDepartureTime;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOperatingAirlines() {
        return operatingAirlines;
    }

    public void setOperatingAirlines(String operatingAirlines) {
        this.operatingAirlines = operatingAirlines;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Timestamp getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }
}
