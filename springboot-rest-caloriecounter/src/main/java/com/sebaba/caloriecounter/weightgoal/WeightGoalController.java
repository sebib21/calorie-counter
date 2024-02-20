package com.sebaba.caloriecounter.weightgoal;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weightgoals")
public class WeightGoalController {

	private final WeightGoalService weightGoalService;

	public WeightGoalController(WeightGoalService weightGoalService) {
		this.weightGoalService = weightGoalService;
	}
	
	
	@GetMapping
	public List<RetrieveWeightGoalDTO> findAllWeightGoals() {
		return weightGoalService.findAllWeightGoals();
	}
	
}