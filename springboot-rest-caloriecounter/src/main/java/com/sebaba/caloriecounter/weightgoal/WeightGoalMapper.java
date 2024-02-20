package com.sebaba.caloriecounter.weightgoal;

import org.springframework.stereotype.Service;

@Service
class WeightGoalMapper {
	
	public RetrieveWeightGoalDTO toRetrieveWeightGoalDTO(WeightGoal weightGoal) {
		return new RetrieveWeightGoalDTO(
				weightGoal.getWeightGoalId(),
				weightGoal.getName(),
				weightGoal.getDescription(),
				weightGoal.getCalories());
	}
	
}