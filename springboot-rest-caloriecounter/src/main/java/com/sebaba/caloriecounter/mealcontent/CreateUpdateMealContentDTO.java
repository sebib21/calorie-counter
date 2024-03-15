package com.sebaba.caloriecounter.mealcontent;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public record CreateUpdateMealContentDTO(
		
		@NotNull(message = "The product must be specified!")
		Long productId,
		
		@NotNull(message = "The meal must be specified!")
		Long mealId,
		
		@NotNull(message = "The serving size of the product must be specified!")
		@Range(min = (long) 0.1, max = (long) 99.9, message = "The serving size of the product must be between 0.1 and 99.9!")
		Double servingSize
		
){}