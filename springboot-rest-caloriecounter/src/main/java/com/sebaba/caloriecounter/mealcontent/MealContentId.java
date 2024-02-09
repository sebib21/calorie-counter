package com.sebaba.caloriecounter.mealcontent;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class MealContentId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "meal_id")
	private Long mealId;

	
	public MealContentId() {}

	public MealContentId(Long productId, Long mealId) {
		this.productId = productId;
		this.mealId = mealId;
	}

	public Long getProductId() {
		return productId;
	}

	public Long getMealId() {
		return mealId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mealId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		MealContentId other = (MealContentId) obj;
		return Objects.equals(mealId, other.mealId) && Objects.equals(productId, other.productId);
	}

}