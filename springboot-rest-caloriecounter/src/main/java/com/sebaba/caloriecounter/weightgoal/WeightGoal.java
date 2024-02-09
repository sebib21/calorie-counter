package com.sebaba.caloriecounter.weightgoal;

import java.util.List;

import com.sebaba.caloriecounter.objective.Objective;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "WeightGoal")
@Table(name = "weight_goal")
public class WeightGoal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "weight_goal_id")
	private Integer weightGoalId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "calories")
	private Short calories;

	@OneToMany(mappedBy = "weightGoal")
	private List<Objective> objectiveList;
	
	public WeightGoal() {}
	
	public WeightGoal(String name, String description, Short calories) {
		this.name = name;
		this.description = description;
		this.calories = calories;
	}

	public Integer getWeightGoalId() {
		return weightGoalId;
	}

	public void setWeightGoalId(Integer weightGoalId) {
		this.weightGoalId = weightGoalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getCalories() {
		return calories;
	}

	public void setCalories(Short calories) {
		this.calories = calories;
	}

	public List<Objective> getObjectiveList() {
		return objectiveList;
	}

	public void setObjectiveList(List<Objective> objectiveList) {
		this.objectiveList = objectiveList;
	}

	@Override
	public String toString() {
		return "WeightGoal [weightGoalId=" + weightGoalId + ", name=" + name + ", description=" + description
				+ ", calories=" + calories + "]";
	}
	
}