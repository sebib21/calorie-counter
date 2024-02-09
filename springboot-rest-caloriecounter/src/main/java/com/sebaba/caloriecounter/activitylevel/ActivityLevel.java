package com.sebaba.caloriecounter.activitylevel;

import java.util.List;

import com.sebaba.caloriecounter.person.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "ActivityLevel")
@Table(name = "activity_level")
public class ActivityLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_level_id")
	private Integer activityLevelId;
	
	@Column(name = "description")
	private String descripion;
	
	@Column(name = "multiplier")
	private	Double multiplier;
	
	@OneToMany(mappedBy = "activityLevel")
	private List<Person> personList;

	
	public ActivityLevel() {}

	public ActivityLevel(String descripion, Double multiplier) {
		this.descripion = descripion;
		this.multiplier = multiplier;
	}

	public Integer getActivityLevelId() {
		return activityLevelId;
	}

	public void setActivityLevelId(Integer activityLevelId) {
		this.activityLevelId = activityLevelId;
	}

	public String getDescripion() {
		return descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	public Double getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(Double multiplier) {
		this.multiplier = multiplier;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	@Override
	public String toString() {
		return "ActivityLevel [activityLevelId=" + activityLevelId + ", descripion=" + descripion + ", multiplier="
				+ multiplier + "]";
	}
	
}