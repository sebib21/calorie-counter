package com.sebaba.caloriecounter.core.validation;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BirthDateValidator implements ConstraintValidator<BirthDateValidation, LocalDate> {

	private int minAge;
	private int maxAge;
	
	@Override
	public void initialize(BirthDateValidation constraintAnnotation) {
		this.minAge = constraintAnnotation.minAge();
		this.maxAge = constraintAnnotation.maxAge();
	}

	@Override
	public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext context) {
		if (dateOfBirth == null) {
			return false;
		}

		LocalDate currentDate = LocalDate.now();
        LocalDate minDate = currentDate.minusYears(minAge);
        LocalDate maxDate = currentDate.minusYears(maxAge);
        
        if(dateOfBirth.isAfter(minDate) || dateOfBirth.isBefore(maxDate)) {
        	return false;
        }
		
        return true;
	}

}