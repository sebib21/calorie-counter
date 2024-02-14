package com.sebaba.caloriecounter.macronutrient;

import org.springframework.stereotype.Service;

@Service
public class MacronutrientMapper {

	public RetrieveMacronutrientDTO toRetrieveMacronutrientDTO(Macronutrient macronutrient) {
		return new RetrieveMacronutrientDTO(
				macronutrient.getMacronutrientId(),
				macronutrient.getNutrient(),
				macronutrient.getKcalPerGram());
	}
	
}