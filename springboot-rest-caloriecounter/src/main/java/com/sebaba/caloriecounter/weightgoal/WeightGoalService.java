package com.sebaba.caloriecounter.weightgoal;

import java.util.List;

public interface WeightGoalService {

	public List<RetrieveWeightGoalDTO> findAllWeightGoals();

	public RetrieveWeightGoalDTO findWeightGoalById(Integer weightGoalId);
}