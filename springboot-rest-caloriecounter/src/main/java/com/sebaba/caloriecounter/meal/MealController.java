package com.sebaba.caloriecounter.meal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/meals")
class MealController {

	private final MealService mealService;

	public MealController(MealService mealService) {
		this.mealService = mealService;
	}

	
	@GetMapping
	List<RetrieveMealDTO> findMealsByDateAndPersonId(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date, 
															@RequestParam Long personId) {
		return mealService.findMealsByDateAndPersonId(date, personId);
	}

	@PostMapping
	void saveMeal(@Valid @RequestBody CreateMealDTO createMealDTO) {
		mealService.saveMeal(createMealDTO);
	}

	@DeleteMapping("{mealId}")
	void deleteMeal(@PathVariable Long mealId) {
		mealService.deleteMeal(mealId);
	}

}