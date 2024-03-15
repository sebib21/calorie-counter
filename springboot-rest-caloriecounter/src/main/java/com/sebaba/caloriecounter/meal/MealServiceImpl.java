package com.sebaba.caloriecounter.meal;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

// TODO: authorization and authentication checks
@Service
class MealServiceImpl implements MealService {

	private final MealRepository mealRepository;
	private final MealMapper mealMapper;
	
	public MealServiceImpl(MealRepository mealRepository, MealMapper mealMapper) {
		this.mealRepository = mealRepository;
		this.mealMapper = mealMapper;
	}

	// TODO: may need a PersonDTO parameter for this function
	@Override
	public List<RetrieveMealDTO> findMealsByDateAndPersonId(LocalDate date, Long personId) {
		return mealRepository
				.findByMealDateAndPersonPersonId(date, personId)
				.stream()
				.map(mealMapper::toRetrieveMealDTO)
				.collect(Collectors.toList());
	}

	@Override
	public void saveMeal(CreateMealDTO createMealDTO) {
		mealRepository.save(mealMapper.toMeal(createMealDTO));
	}

	@Override
	public void deleteMeal(Long mealId) {
		mealRepository.deleteById(mealId);
	}

}