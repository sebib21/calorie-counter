package com.sebaba.caloriecounter.weightgoal;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weightgoals")
class WeightGoalController {

	private final WeightGoalService weightGoalService;

	public WeightGoalController(WeightGoalService weightGoalService) {
		this.weightGoalService = weightGoalService;
	}
	
	
	@GetMapping
	List<RetrieveWeightGoalDTO> findAllWeightGoals() {
		return weightGoalService.findAllWeightGoals();
	}
	
}