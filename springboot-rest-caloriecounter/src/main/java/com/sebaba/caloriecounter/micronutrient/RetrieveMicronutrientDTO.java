package com.sebaba.caloriecounter.micronutrient;

public record RetrieveMicronutrientDTO(
		Integer micronutrientId,
		String nutrient,
		String type,
		String units,
		Double menRDA,
		Double womenRDA,
		Double upperLimit
){}