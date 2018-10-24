package com.nana.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class emailAddressConstraintValidator implements ConstraintValidator<EmailAddress, String> {

   private String emailSuffix;

   public void initialize(EmailAddress constraint) {
      emailSuffix = constraint.value();
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {

      boolean result = true;

      if (obj != null) {
         // result = obj.endsWith(emailSuffix);
         if (obj.length() <= 4) {
            result = contextErrorHandler(context, "length must greater than 4");
         } else if (obj.contains("+") | obj.contains("-")) {
            result = contextErrorHandler(context, "must not contain + or -");
         } else if (!obj.contains("@")) {
            result = contextErrorHandler(context, "must contain @");
         }
      }

      return result;
   }

   private boolean contextErrorHandler(ConstraintValidatorContext context, String s) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(s).addConstraintViolation();
      return false;
   }
}
