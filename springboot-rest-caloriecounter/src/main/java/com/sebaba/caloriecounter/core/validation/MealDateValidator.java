package com.sebaba.caloriecounter.core.validation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MealDateValidator implements ConstraintValidator<MealDateValidation, LocalDate> {

	@Override
    public void initialize(MealDateValidation mealDateValidation) {
    }

    @Override
    public boolean isValid(LocalDate mealDate, ConstraintValidatorContext context) {
    	
        if (mealDate == null) {
            return false;
        }

        return Math.abs(ChronoUnit.DAYS.between(LocalDate.now(), mealDate)) <= 1;
        
    }
	
}