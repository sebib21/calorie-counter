package com.sebaba.caloriecounter.nutrienttarget;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public record CreateNutrientTargetDTO(
		
		@NotNull(message = "Macronutrient must be specified!")
		Integer macronutrientId,
		
		@NotNull(message = "Percentage of macronutrient must be specified!")
		@Range(min = 0, max = 100, message = "Percentage range must be between 0% and 100%!")
		Double percentage
		
){}