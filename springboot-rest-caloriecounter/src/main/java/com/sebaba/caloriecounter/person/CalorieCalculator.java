package com.sebaba.caloriecounter.person;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

@Service
class CalorieCalculator {

	// Calculates the Basal Metabolic Rate(BMR) using Harris-Benedict formula
	private double getBasalMetabolicRate(Person personInfo) {

		final int age = Period.between(personInfo.getDateOfBirth(), LocalDate.now()).getYears();
		
		if("M".equals(personInfo.getGender())) {
			return 66 + (13.7 * personInfo.getWeight()) + (500 * personInfo.getHeight()) - (6.8 * age);
		} else if ("F".equals(personInfo.getGender())) {
			return 655 + (9.6 * personInfo.getWeight()) + (180 * personInfo.getHeight()) - (4.7 * age);
		} else {
			throw new IllegalArgumentException("Invalid gender!");
		}
	}

	// Calculates the Total Daily Energy Expenditure(TDEE) based on the activity level multiplier
	public double getDailyBurnedCalories(Person personInfo, double activityLevelmultiplier) {		
		return getBasalMetabolicRate(personInfo) * activityLevelmultiplier;
	}
	
	// Calculates the calories for different weight objectives (gain, loss, maintain)
	public double getObjectiveWeightCalories(Person personInfo, double activityLevelmultiplier, int calorieModifier) {
		return getDailyBurnedCalories(personInfo, activityLevelmultiplier) + calorieModifier;
	}
	
}