package com.sebaba.caloriecounter.macronutrient;

import java.util.List;

public interface MacronutrientService {

	public List<RetrieveMacronutrientDTO> findAllMacronutrients();
	
	public Macronutrient findMacronutrientById(Integer macronutrientId);
	
}