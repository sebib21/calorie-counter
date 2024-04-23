package com.sebaba.caloriecounter.person;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.activitylevel.ActivityLevel;
import com.sebaba.caloriecounter.activitylevel.ActivityLevelService;
import com.sebaba.caloriecounter.activitylevel.RetrieveActivityLevelDTO;
import com.sebaba.caloriecounter.core.exception.InvalidObjectiveException;
import com.sebaba.caloriecounter.objective.Objective;
import com.sebaba.caloriecounter.objective.ObjectiveMapper;

@Service
public class PersonMapper {

	private final ActivityLevelService activityLevelService;
	private final ObjectiveMapper objectiveMapper;
	private final CalorieCalculator calorieCalculator;

	public PersonMapper(ActivityLevelService activityLevelService, ObjectiveMapper objectiveMapper, CalorieCalculator calorieCalculator) {
		this.activityLevelService = activityLevelService;
		this.objectiveMapper = objectiveMapper;
		this.calorieCalculator = calorieCalculator;
	}


	public RetrievePersonDTO toRetrievePersonDTO(Person person) {
		return new RetrievePersonDTO(
				person.getFirstName(),
				person.getFirstName(),
				person.getGender(),
				person.getDateOfBirth(),
				person.getHeight(),
				person.getWeight(),
				person.getActivityLevel().getDescripion()
				);
	}
	
	
	public Person toPerson(CreatePersonDTO createPersonDTO) {
		Person person = new Person(
				createPersonDTO.firstName(), 
				createPersonDTO.lastName(), 
				createPersonDTO.gender(), 
				createPersonDTO.dateOfBirth(), 
				createPersonDTO.height(), 
				createPersonDTO.weight()
				);
		
		// set activity level
		RetrieveActivityLevelDTO retrieveActivityLevelDTO = activityLevelService.findActivityLevelById(createPersonDTO.activityLevelId());
		ActivityLevel activityLevel = new ActivityLevel();
		activityLevel.setActivityLevelId(createPersonDTO.activityLevelId());
		person.setActivityLevel(activityLevel);
		
		// set objective
		Objective objective = objectiveMapper.toObjective(createPersonDTO.objective());
		
		Short calorieModifier = objective.getWeightGoal().getCalories();
		
		if (objective.getWeight() >= person.getWeight() && calorieModifier >= 0
				|| objective.getWeight() < person.getWeight() && calorieModifier < 0) {
			objective.setDailyKcal(calorieCalculator.getObjectiveWeightCalories(person, retrieveActivityLevelDTO.multiplier(), calorieModifier ));
			person.setObjective(objective);		
		} else {
			throw new InvalidObjectiveException("The objective weight goal is invalid!");
		}

		return person;
	}
	
}