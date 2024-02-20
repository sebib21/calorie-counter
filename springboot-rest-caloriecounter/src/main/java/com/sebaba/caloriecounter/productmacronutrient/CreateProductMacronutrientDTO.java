package com.sebaba.caloriecounter.productmacronutrient;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public record CreateProductMacronutrientDTO(
		
		@NotNull(message = "Macronutrient must be specified!")
		Integer macronutrientId,
		
		@NotNull(message = "Macronutrient content can't be null!")
		@Range(min = 0, max = 100, message = "Macronutrient content must be between 0 and 100!")
		Double content
){}