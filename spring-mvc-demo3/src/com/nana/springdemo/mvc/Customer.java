package com.nana.springdemo.mvc;

import com.nana.springdemo.mvc.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    // Add validation rules for lastName
    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;

    // Add validation rule for freePass
    @NotNull(message = "is required")
    @Min(value = 0, message="must be greater than or equal to zero")
    @Max(value = 10, message="must less than or equal to 10")
    private Integer freePass;

    // Add validation rule for PostalCode
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 characters/digits")
    private String postalCode;

    //
    @CourseCode(value="TOPS", message = "must start with TOPS") // default value already defined
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

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

    public Integer getFreePass() {
        return freePass;
    }

    public void setFreePass(Integer freePass) {
        this.freePass = freePass;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
