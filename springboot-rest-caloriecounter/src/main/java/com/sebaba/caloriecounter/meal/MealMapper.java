package com.sebaba.caloriecounter.meal;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.mealcontent.MealContentMapper;
import com.sebaba.caloriecounter.person.Person;

@Service
public class MealMapper {

	private final MealContentMapper mealContentMapper;
	
	public MealMapper(MealContentMapper mealContentMapper) {
		this.mealContentMapper = mealContentMapper;
	}


	public RetrieveMealDTO toRetrieveMealDTO(Meal meal) {
		return new RetrieveMealDTO(
				meal.getMealId(),
				meal.getMealDate(),
				meal.getMealContentList()
					.stream()
					.map(mealContentMapper::toRetrieveMealContentDTO)
					.collect(Collectors.toList())
				);
	}
	
	
	public Meal toMeal(CreateMealDTO createMealDTO) {
		
		Person person = new Person();
		person.setPersonId(createMealDTO.personId());
		
		Meal meal = new Meal(createMealDTO.mealDate());
		meal.setPerson(person);
		
		return meal;
	}
}