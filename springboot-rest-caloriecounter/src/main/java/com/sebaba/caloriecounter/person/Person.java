package com.sebaba.caloriecounter.person;

import java.time.LocalDate;
import java.util.List;

import com.sebaba.caloriecounter.activitylevel.ActivityLevel;
import com.sebaba.caloriecounter.meal.Meal;
import com.sebaba.caloriecounter.objective.Objective;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "Person")
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private Long personId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")
	private Character gender;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "height")
	private Double height;
	
	@Column(name = "weight")
	private Double weight;
	
	@OneToMany(mappedBy = "person")
	private List<Meal> mealList;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_level_id")
	private ActivityLevel activityLevel;
	
	@OneToOne
	@JoinColumn(name = "objective_id")
	private Objective objective;

	
	public Person() {}

	public Person(String firstName, String lastName, Character gender, LocalDate dateOfBirth, Double height,
			Double weight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.weight = weight;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public List<Meal> getMealList() {
		return mealList;
	}

	public void setMealList(List<Meal> mealList) {
		this.mealList = mealList;
	}

	public ActivityLevel getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(ActivityLevel activityLevel) {
		this.activityLevel = activityLevel;
	}

	public Objective getObjective() {
		return objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", height=" + height + ", weight=" + weight + "]";
	}
	
}