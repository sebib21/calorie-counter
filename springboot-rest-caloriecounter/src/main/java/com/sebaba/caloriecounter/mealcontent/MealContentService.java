package com.sebaba.caloriecounter.mealcontent;

public interface MealContentService {
	
	public void saveOrUpdateMealContent(CreateUpdateMealContentDTO createUpdateMealContentDTO);
		
	public void deleteMealContent(Long productId, Long mealId);
	
}