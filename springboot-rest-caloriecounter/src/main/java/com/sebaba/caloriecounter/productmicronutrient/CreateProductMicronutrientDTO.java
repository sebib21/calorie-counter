package com.sebaba.caloriecounter.productmicronutrient;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public record CreateProductMicronutrientDTO(
		
		@NotNull(message = "Micronutrient must be specified!")
		Integer micronutrientId,
		
		@Range(min = 0, max = 10000, message = "Micronutrient content must be null or between 0 and 10000!")
		Double content
){}