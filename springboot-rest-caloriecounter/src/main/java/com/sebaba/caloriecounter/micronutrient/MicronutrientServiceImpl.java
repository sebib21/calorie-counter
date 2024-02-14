package com.sebaba.caloriecounter.micronutrient;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.core.exception.MicronutrientNotFoundException;

@Service
class MicronutrientServiceImpl implements MicronutrientService {

	private final MicronutrientRepository micronutrientRepository;
	private final MicronutrientMapper micronutrientMapper;
	
	public MicronutrientServiceImpl(MicronutrientRepository micronutrientRepository, MicronutrientMapper micronutrientMapper) {
		this.micronutrientRepository = micronutrientRepository;
		this.micronutrientMapper = micronutrientMapper;
	}

	
	@Override
	public List<RetrieveMicronutrientDTO> findAllMicronutrients() {
		return micronutrientRepository
				.findAll()
				.stream()
				.map(micronutrientMapper::toRetrieveMicronutrientDTO)
				.collect(Collectors.toList());
	}


	@Override
	public Micronutrient findMicronutrientById(Integer micronutrientId) {
		return micronutrientRepository
				.findById(micronutrientId)
				.orElseThrow(MicronutrientNotFoundException::new);
	}

}