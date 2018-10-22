package com.nana.springdemo.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = emailAddressConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailAddress {

    // define default email address
    public String value() default "@test.com";

    // define default message
    public String message() default "must with email address @test.com";

    // define default group
    public Class<?>[] groups() default {};

    // define default payload
    public Class<? extends Payload>[] payload() default {};

}
