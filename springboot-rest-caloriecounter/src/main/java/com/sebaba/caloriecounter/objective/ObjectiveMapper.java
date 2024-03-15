package com.sebaba.caloriecounter.objective;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.nutrienttarget.RetrieveNutrientTargetDTO;
import com.sebaba.caloriecounter.weightgoal.WeightGoal;
import com.sebaba.caloriecounter.weightgoal.WeightGoalService;

@Service
public class ObjectiveMapper {

	private final WeightGoalService weightGoalService;
	
	public ObjectiveMapper(WeightGoalService weightGoalService) {
		this.weightGoalService = weightGoalService;
	}


	public RetrieveObjectiveDTO toRetrieveObjectiveDTO(Objective objective) {
		return new RetrieveObjectiveDTO(
				objective.getWeight(),
				objective.getDailyKcal(),
				objective.getNutrientTargetList()
							.stream()
							.map(nutrientTarget -> new RetrieveNutrientTargetDTO(
									nutrientTarget.getMacronutrient().getNutrient(), 
									nutrientTarget.getPercentage(), 
									nutrientTarget.getGrams()
									)
								)
							.collect(Collectors.toList())
				);
	}

	public Objective toObjective(CreateUpdateObjectiveDTO createUpdateObjectiveDTO) {
		
		Double dailyKcal = null;
		
		Objective objective = new Objective(createUpdateObjectiveDTO.weight(), dailyKcal);
		
		if(weightGoalService.findWeightGoalById(createUpdateObjectiveDTO.weightGoalId()) != null) {
			WeightGoal weightGoal = new WeightGoal();
			weightGoal.setWeightGoalId(createUpdateObjectiveDTO.weightGoalId());
			objective.setWeightGoal(weightGoal);
		}
		
		return objective;
	}
	
}