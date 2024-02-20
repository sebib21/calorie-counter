package com.sebaba.caloriecounter.weightgoal;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.core.exception.WeightGoalNotFoundException;

@Service
class WeightGoalServiceImpl implements WeightGoalService {

	private final WeightGoalRepository weightGoalRepository;
	private final WeightGoalMapper weightGoalMapper;
	
	public WeightGoalServiceImpl(WeightGoalRepository weightGoalRepository, WeightGoalMapper weightGoalMapper) {
		this.weightGoalRepository = weightGoalRepository;
		this.weightGoalMapper = weightGoalMapper;
	}

	
	@Override
	public List<RetrieveWeightGoalDTO> findAllWeightGoals() {
		return weightGoalRepository
				.findAll()
				.stream()
				.map(weightGoalMapper::toRetrieveWeightGoalDTO)
				.collect(Collectors.toList());
	}

	@Override
	public RetrieveWeightGoalDTO findWeightGoalById(Integer weightGoalId) {
		return weightGoalRepository
				.findById(weightGoalId)
				.map(weightGoalMapper::toRetrieveWeightGoalDTO)
				.orElseThrow(WeightGoalNotFoundException::new);
	}

}