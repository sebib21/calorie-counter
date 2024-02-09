package com.sebaba.caloriecounter.meal;

import java.time.LocalDate;
import java.util.List;

import com.sebaba.caloriecounter.mealcontent.MealContent;
import com.sebaba.caloriecounter.person.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Meal")
@Table(name = "meal")
public class Meal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "meal_id")
	private Long mealId;
	
	@Column(name = "meal_date")
	private LocalDate mealDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id")
	private Person person;
	
	@OneToMany(mappedBy = "meal")
	private List<MealContent> mealContentList;

	
	public Meal() {}

	public Meal(LocalDate mealDate) {
		this.mealDate = mealDate;
	}

	public Long getMealId() {
		return mealId;
	}

	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	public LocalDate getMealDate() {
		return mealDate;
	}

	public void setMealDate(LocalDate mealDate) {
		this.mealDate = mealDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<MealContent> getMealContentList() {
		return mealContentList;
	}

	public void setMealContentList(List<MealContent> mealContentList) {
		this.mealContentList = mealContentList;
	}

	@Override
	public String toString() {
		return "Meal [mealId=" + mealId + ", mealDate=" + mealDate + "]";
	}
	
}