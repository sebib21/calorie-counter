package com.sebaba.caloriecounter.micronutrient;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/micronutrients")
public class MicronutrientController {

	private final MicronutrientService micronutrientService;

	public MicronutrientController(MicronutrientService micronutrientService) {
		this.micronutrientService = micronutrientService;
	}
	
	
	@GetMapping
	public List<RetrieveMicronutrientDTO> findAllMicronutrients(){
		return micronutrientService.findAllMicronutrients();
	}
	
}