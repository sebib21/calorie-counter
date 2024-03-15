package com.sebaba.caloriecounter.mealcontent;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/meals/contents")
public class MealContentController {

	private final MealContentService mealContentService;

	public MealContentController(MealContentService mealContentService) {
		this.mealContentService = mealContentService;
	}


	@PostMapping
	public void saveOrUpdateMealContent(@Valid @RequestBody CreateUpdateMealContentDTO createUpdateMealContentDTO) {
		mealContentService.saveOrUpdateMealContent(createUpdateMealContentDTO);
	}

	@DeleteMapping
	public void deleteMealContent(@RequestParam Long productId, @RequestParam Long mealId) {
		mealContentService.deleteMealContent(productId, mealId);
	}

}