package com.sebaba.caloriecounter.objective;

import java.util.List;

import com.sebaba.caloriecounter.nutrienttarget.RetrieveNutrientTargetDTO;

record RetrieveObjectiveDTO(
		Double weight,
		Double dailyKcal,
		List<RetrieveNutrientTargetDTO> nutrientTargetList
){}