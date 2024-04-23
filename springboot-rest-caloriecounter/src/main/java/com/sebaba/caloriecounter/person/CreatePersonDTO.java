package com.sebaba.caloriecounter.person;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import com.sebaba.caloriecounter.core.validation.BirthDateValidation;
import com.sebaba.caloriecounter.core.validation.NamingValidation;
import com.sebaba.caloriecounter.objective.CreateUpdateObjectiveDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

record CreatePersonDTO(
		
		@NamingValidation(minLength = 2, maxLength = 50, message = "First name must be specified and have between 2 and 50 characters!")
		String firstName,
		
		@NamingValidation(minLength = 2, maxLength = 50, message = "Last name must be specified and have between 2 and 50 characters!")
		String lastName,
		
		@Pattern(regexp = "^[M|F]$", message = "Gender must be M(ale) or F(emale)!")
		String gender,
		
		@BirthDateValidation(minAge = 16, maxAge = 90, message = "Valid age range is between 16 and 90!")
		LocalDate dateOfBirth,
		
		@NotNull(message = "Height must be specified!")
		@Range(min = (long) 1.40, max = (long) 2.20, message = "Height must be between 1.40 and 2.20 meters!")
		Double height,
		
		@NotNull(message = "Weight must be specified!")
		@Range(min = 30, max = 180, message = "Weight must be between 30 and 180 kilograms!")
		Double weight,
		
		@NotNull(message = "Activity level must be specified!")
		Integer activityLevelId,
		
		@Valid
		@NotNull(message = "Objective must be specified!")
		CreateUpdateObjectiveDTO objective
		
){}