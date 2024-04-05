package com.sebaba.caloriecounter.micronutrient;

record RetrieveMicronutrientDTO(
		Integer micronutrientId,
		String nutrient,
		String type,
		String units,
		Double menRDA,
		Double womenRDA,
		Double upperLimit
){}