package com.nana.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class emailAddressConstraintValidator implements ConstraintValidator<EmailAddress, String> {

   private String emailSuffix;

   public void initialize(EmailAddress constraint) {
      emailSuffix = constraint.value();
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {

      boolean result;

      if (obj != null) {
         result = obj.endsWith(emailSuffix);
      } else {
         return true;
      }

      return result;
   }
}
