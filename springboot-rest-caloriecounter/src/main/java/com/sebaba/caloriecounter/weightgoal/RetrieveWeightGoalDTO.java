package com.sebaba.caloriecounter.weightgoal;

public record RetrieveWeightGoalDTO(
		Integer weightGoalId,
		String name,
		String description,
		Short calories
){}