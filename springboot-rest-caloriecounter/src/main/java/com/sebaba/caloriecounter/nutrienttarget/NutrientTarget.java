package com.sebaba.caloriecounter.nutrienttarget;

import com.sebaba.caloriecounter.macronutrient.Macronutrient;
import com.sebaba.caloriecounter.objective.Objective;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "NutrientTarget")
@Table(name = "nutrient_target")
public class NutrientTarget {

	@EmbeddedId
	private NutrientTargetId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("objectiveId")
	@JoinColumn(name = "objective_id")
	private Objective objective;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("macronutrientId")
	@JoinColumn(name = "macronutrient_id")
	private Macronutrient macronutrient;
	
	@Column(name = "percentage")
	private Double percentage;

	
	public NutrientTarget() {}

	public NutrientTarget(Objective objective, Macronutrient macronutrient, Double percentage) {
		this.id = new NutrientTargetId(objective.getObjectiveId(), macronutrient.getMacronutrientId());
		this.objective = objective;
		this.macronutrient = macronutrient;
		this.percentage = percentage;
	}

	public NutrientTargetId getId() {
		return id;
	}

	public void setId(NutrientTargetId id) {
		this.id = id;
	}

	public Objective getObjective() {
		return objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	public Macronutrient getMacronutrient() {
		return macronutrient;
	}

	public void setMacronutrient(Macronutrient macronutrient) {
		this.macronutrient = macronutrient;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "NutrientTarget [id=" + id + ", objective=" + objective + ", macronutrient=" + macronutrient
				+ ", percentage=" + percentage + "]";
	}
	
}