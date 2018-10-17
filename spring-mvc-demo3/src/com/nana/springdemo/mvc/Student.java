package com.nana.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

    private String firstName, lastName;
    private String country;

    private LinkedHashMap<String, String> countryOptions;

    public Student() {
        // popluate country options: used ISO country code
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("IN", "India");
        countryOptions.put("DE", "Germany");
        countryOptions.put("CA", "Canada");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

