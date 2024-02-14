package com.sebaba.caloriecounter.macronutrient;

public record RetrieveMacronutrientDTO(
		Integer macronutrientId,
		String nutrient,
		Byte kcalPerGram
){}