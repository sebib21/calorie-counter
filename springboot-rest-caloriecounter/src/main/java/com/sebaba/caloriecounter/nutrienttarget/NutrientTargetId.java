package com.sebaba.caloriecounter.nutrienttarget;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class NutrientTargetId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "objective_id")
	private Long objectiveId;
	
	@Column(name = "macronutrient_id")
	private Integer macronutrientId;
	
	
	public NutrientTargetId() {}

	public NutrientTargetId(Long objectiveId, Integer macronutrientId) {
		this.objectiveId = objectiveId;
		this.macronutrientId = macronutrientId;
	}

	public Long getObjectiveId() {
		return objectiveId;
	}

	public Integer getMacronutrientId() {
		return macronutrientId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(macronutrientId, objectiveId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		NutrientTargetId other = (NutrientTargetId) obj;
		return Objects.equals(macronutrientId, other.macronutrientId) && Objects.equals(objectiveId, other.objectiveId);
	}

}