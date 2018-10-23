package com.nana.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeContraintValidator implements ConstraintValidator<CourseCode, String> {

   private String coursePrefix;

   public void initialize(CourseCode theCourseCode) {
      coursePrefix = theCourseCode.value();
   }

   // vactual validation rules
   public boolean isValid(String theCode, ConstraintValidatorContext context) {

      boolean result;

      if (theCode != null) {
         result = theCode.startsWith(coursePrefix);
      } else {
         return true;
      }

      return result;
   }
}
