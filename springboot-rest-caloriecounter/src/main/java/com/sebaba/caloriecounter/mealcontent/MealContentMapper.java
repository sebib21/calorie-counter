package com.sebaba.caloriecounter.mealcontent;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.meal.Meal;
import com.sebaba.caloriecounter.product.Product;
import com.sebaba.caloriecounter.product.ProductMapper;

@Service
public class MealContentMapper {

	private final ProductMapper productMapper;
	
	public MealContentMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}


	public RetrieveMealContentDTO toRetrieveMealContentDTO(MealContent mealContent) {
		return new RetrieveMealContentDTO(
				mealContent.getMeal().getMealId(),
				productMapper.toRetrieveFullProductDTO(mealContent.getProduct()),
				mealContent.getServingSize()
				);
	}
	
	public MealContent toMealContent(CreateUpdateMealContentDTO createUpdateMealContentDTO) {
		
		Product product = new Product();
		product.setProductId(createUpdateMealContentDTO.productId());
		
		Meal meal = new Meal();
		meal.setMealId(createUpdateMealContentDTO.mealId());
		
		return new MealContent(product, meal, createUpdateMealContentDTO.servingSize());
	}
	
}