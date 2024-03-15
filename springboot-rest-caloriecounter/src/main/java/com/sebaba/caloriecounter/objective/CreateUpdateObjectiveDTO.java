package com.sebaba.caloriecounter.objective;

import java.util.List;

import com.sebaba.caloriecounter.nutrienttarget.CreateNutrientTargetDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CreateUpdateObjectiveDTO(
		
		@NotNull(message = "The desired weight must be specified!")
		Double weight,
		
		@NotNull(message = "The objective weight goal must be specified!")
		Integer weightGoalId,
		
		@NotNull
		List<@Valid CreateNutrientTargetDTO> nutrientTargetList
		
){}