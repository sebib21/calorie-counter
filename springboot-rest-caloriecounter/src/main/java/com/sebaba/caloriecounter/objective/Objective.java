package com.sebaba.caloriecounter.objective;

import java.util.List;

import com.sebaba.caloriecounter.nutrienttarget.NutrientTarget;
import com.sebaba.caloriecounter.person.Person;
import com.sebaba.caloriecounter.weightgoal.WeightGoal;

import jakarta.persistence.CascadeType;
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

@Entity(name = "Objective")
@Table(name = "objective")
public class Objective {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "objective_id")
	private Long objectiveId;
	
	@Column(name = "weight")
	private Double weight;
	
	@Column(name = "daily_kcal")
	private Double dailyKcal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "weight_goal_id")
	private WeightGoal weightGoal;
	
	@OneToOne(mappedBy = "objective")
	private Person person;
	
	@OneToMany(mappedBy = "objective", cascade = CascadeType.PERSIST)
	private List<NutrientTarget> nutrientTargetList;

	
	public Objective() {}

	public Long getObjectiveId() {
		return objectiveId;
	}

	public void setObjectiveId(Long objectiveId) {
		this.objectiveId = objectiveId;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getDailyKcal() {
		return dailyKcal;
	}

	public void setDailyKcal(Double dailyKcal) {
		this.dailyKcal = dailyKcal;
	}

	public WeightGoal getWeightGoal() {
		return weightGoal;
	}

	public void setWeightGoal(WeightGoal weightGoal) {
		this.weightGoal = weightGoal;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<NutrientTarget> getNutrientTargetList() {
		return nutrientTargetList;
	}

	public void setNutrientTargetList(List<NutrientTarget> nutrientTargetList) {
		this.nutrientTargetList = nutrientTargetList;
	}

	@Override
	public String toString() {
		return "Objective [objectiveId=" + objectiveId + ", weight=" + weight
				+ ", dailyKcal=" + dailyKcal + "]";
	}
	
}