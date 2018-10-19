package com.nana.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

    private String firstName;

    // Add validation rules for lastName
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;

    // Add validation rule for freePass
    @Min(value = 0, message="must be greater than or equal to zero")
    @Max(value = 10, message="must less than or equal to 10")
    private int freePass;

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

    public int getFreePass() {
        return freePass;
    }

    public void setFreePass(int freePass) {
        this.freePass = freePass;
    }
}
