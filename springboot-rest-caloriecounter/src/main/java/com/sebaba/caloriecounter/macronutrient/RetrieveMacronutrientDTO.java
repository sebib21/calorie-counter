package com.sebaba.caloriecounter.macronutrient;

record RetrieveMacronutrientDTO(
		Integer macronutrientId,
		String nutrient,
		Byte kcalPerGram
){}