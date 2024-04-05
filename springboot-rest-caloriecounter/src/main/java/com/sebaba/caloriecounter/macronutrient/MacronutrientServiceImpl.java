package com.sebaba.caloriecounter.macronutrient;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.core.exception.MacronutrientNotFoundException;

@Service
class MacronutrientServiceImpl implements MacronutrientService {

	private final MacronutrientRepository macronutrientRepository;
	private final MacronutrientMapper macronutrientMapper;
	
	public MacronutrientServiceImpl(MacronutrientRepository macronutrientRepository,
			MacronutrientMapper macronutrientMapper) {
		this.macronutrientRepository = macronutrientRepository;
		this.macronutrientMapper = macronutrientMapper;
	}


	@Override
	public List<RetrieveMacronutrientDTO> findAllMacronutrients() {
		return macronutrientRepository
				.findAll()
				.stream()
				.map(macronutrientMapper::toRetrieveMacronutrientDTO)
				.collect(Collectors.toList());
	}

	@Override
	public Macronutrient findMacronutrientById(Integer macronutrientId) {
		return macronutrientRepository
				.findById(macronutrientId)
				.orElseThrow(MacronutrientNotFoundException::new);
	}

}