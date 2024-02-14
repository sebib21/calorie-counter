package com.sebaba.caloriecounter.micronutrient;

import org.springframework.stereotype.Service;

@Service
public class MicronutrientMapper {

	public RetrieveMicronutrientDTO toRetrieveMicronutrientDTO(Micronutrient micronutrient) {
		return new RetrieveMicronutrientDTO(
				micronutrient.getMicronutrientId(),
				micronutrient.getNutrient(),
				micronutrient.getType(),
				micronutrient.getUnits(),
				micronutrient.getMenRDA(),
				micronutrient.getWomenRDA(),
				micronutrient.getUpperLimit());
	}
	
}