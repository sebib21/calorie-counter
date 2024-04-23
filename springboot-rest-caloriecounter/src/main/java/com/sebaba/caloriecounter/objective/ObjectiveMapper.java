package com.sebaba.caloriecounter.objective;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.macronutrient.Macronutrient;
import com.sebaba.caloriecounter.macronutrient.MacronutrientService;
import com.sebaba.caloriecounter.nutrienttarget.NutrientTarget;
import com.sebaba.caloriecounter.nutrienttarget.RetrieveNutrientTargetDTO;
import com.sebaba.caloriecounter.weightgoal.RetrieveWeightGoalDTO;
import com.sebaba.caloriecounter.weightgoal.WeightGoal;
import com.sebaba.caloriecounter.weightgoal.WeightGoalService;

@Service
public class ObjectiveMapper {

	private final WeightGoalService weightGoalService;
	private final MacronutrientService macronutrientService;
	
	public ObjectiveMapper(WeightGoalService weightGoalService, MacronutrientService macronutrientService) {
		this.weightGoalService = weightGoalService;
		this.macronutrientService = macronutrientService;
	}


	public RetrieveObjectiveDTO toRetrieveObjectiveDTO(Objective objective) {
		return new RetrieveObjectiveDTO(
				objective.getWeight(),
				objective.getDailyKcal(),
				objective.getNutrientTargetList()
							.stream()
							.map(nutrientTarget -> new RetrieveNutrientTargetDTO(
									nutrientTarget.getMacronutrient().getNutrient(),
									nutrientTarget.getPercentage()
									)
								)
							.collect(Collectors.toList())
				);
	}

	public Objective toObjective(CreateUpdateObjectiveDTO createUpdateObjectiveDTO) {
		
		RetrieveWeightGoalDTO retrieveWeightGoalDTO = weightGoalService.findWeightGoalById(createUpdateObjectiveDTO.weightGoalId());
				
		Objective objective = new Objective();
		objective.setWeight(createUpdateObjectiveDTO.weight());

		WeightGoal weightGoal = new WeightGoal();
		weightGoal.setWeightGoalId(retrieveWeightGoalDTO.weightGoalId());
		weightGoal.setCalories(retrieveWeightGoalDTO.calories());
		objective.setWeightGoal(weightGoal);

		List<NutrientTarget> nutrientTargetList = new ArrayList<>();
		createUpdateObjectiveDTO.nutrientTargetList()
			.forEach(nutrientTarget -> {
				Macronutrient macronutrient = macronutrientService.findMacronutrientById(nutrientTarget.macronutrientId());
				nutrientTargetList.add(new NutrientTarget(objective, macronutrient, nutrientTarget.percentage()));
		});
		objective.setNutrientTargetList(nutrientTargetList);		

		return objective;
	}
	
}