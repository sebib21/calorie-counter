package com.sebaba.caloriecounter.objective;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import com.sebaba.caloriecounter.nutrienttarget.CreateNutrientTargetDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUpdateObjectiveDTO(
		
		@NotNull(message = "The desired weight must be specified!")
		@Range(min = 30, max = 180, message = "Weight must be between 30 and 180 kilograms!")
		Double weight,
		
		@NotNull(message = "The objective weight goal must be specified!")
		Integer weightGoalId,
		
		@NotNull(message = "Nutrient targets must be specified!")
		@Size(min = 3, max = 3, message = "The number of nutrient targets must be three! (Carbs, Fat and Protein)")
		List<@Valid CreateNutrientTargetDTO> nutrientTargetList
		
){}