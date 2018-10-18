package com.nana.springdemo.mvc;

import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Controller
public class Customer {

    private String firstName;

    // Add validation rules for lastName
    @NotNull(message="is required")
    @Size(min=1)
    private String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
