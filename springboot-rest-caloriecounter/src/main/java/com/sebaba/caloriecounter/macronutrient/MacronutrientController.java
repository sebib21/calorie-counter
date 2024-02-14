package com.sebaba.caloriecounter.macronutrient;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/macronutrients")
public class MacronutrientController {

	private final MacronutrientService macronutrientService;

	public MacronutrientController(MacronutrientService macronutrientService) {
		this.macronutrientService = macronutrientService;
	}
	
	
	@GetMapping
	public List<RetrieveMacronutrientDTO> findAllMacronutrients() {
		return macronutrientService.findAllMacronutrients();
	}
	
}