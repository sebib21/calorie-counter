package com.sebaba.caloriecounter.meal;

import java.time.LocalDate;
import java.util.List;

public interface MealService {
	
	public List<RetrieveMealDTO> findMealsByDateAndPersonId(LocalDate date, Long personId);	
	
	public void saveMeal(CreateMealDTO createMealDTO);
	
	public void deleteMeal(Long mealId);

}