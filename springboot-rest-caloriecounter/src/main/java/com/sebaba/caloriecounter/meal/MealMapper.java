package com.sebaba.caloriecounter.meal;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.mealcontent.MealContentMapper;
import com.sebaba.caloriecounter.person.Person;
import com.sebaba.caloriecounter.person.PersonService;

@Service
public class MealMapper {

	private final PersonService personService;
	private final MealContentMapper mealContentMapper;
	
	public MealMapper(PersonService personService, MealContentMapper mealContentMapper) {
		this.personService = personService;
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
		Meal meal = new Meal(createMealDTO.mealDate());
		
		if(personService.findPersonInfoById(createMealDTO.personId()) != null){
			Person person = new Person();
			person.setPersonId(createMealDTO.personId());
			
			meal.setPerson(person);
		}
		
		return meal;
	}
}