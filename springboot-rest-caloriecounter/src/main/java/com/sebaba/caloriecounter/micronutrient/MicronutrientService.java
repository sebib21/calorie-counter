package com.sebaba.caloriecounter.micronutrient;

import java.util.List;

public interface MicronutrientService {

	public List<RetrieveMicronutrientDTO> findAllMicronutrients();
	
	public Micronutrient findMicronutrientById(Integer micronutrientId);
	
}