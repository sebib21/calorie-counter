package com.sebaba.caloriecounter.person;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import com.sebaba.caloriecounter.core.validation.NamingValidation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreatePersonDTO(
		
		@NamingValidation(minLength = 2, maxLength = 50, message = "")
		String firstName,
		
		@NamingValidation(minLength = 2, maxLength = 50, message = "")
		String lastName,
		
		@Pattern(regexp = "^[M|F]$", message = "Gender must be M(ale) or F(emale)!")
		Character gender,
		
		// TODO: validate the date to be in the past max 100 years ago and not less than 16 years ago
		LocalDate dateOfBirth,
		
		@NotNull(message = "Height must be specified!")
		@Range(min = (long) 1.40, max = (long) 2.20, message = "Height must be between 1.40 and 2.20 meters!")
		Double height,
		
		@NotNull(message = "Weight must be specified!")
		@Range(min = 30, max = 180, message = "Weight must be between 30 and 180 kilograms!")
		Double weight,
		
		@NotNull(message = "Activity level must be specified!")
		Integer activityLevelId
		
){}