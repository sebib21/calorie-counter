package com.sebaba.caloriecounter.meal;

import java.time.LocalDate;

import com.sebaba.caloriecounter.core.validation.MealDateValidation;

import jakarta.validation.constraints.NotNull;

record CreateMealDTO(
		
		@MealDateValidation
		LocalDate mealDate,
		
		@NotNull(message = "The person must be specified!")
		Long personId
		
){}