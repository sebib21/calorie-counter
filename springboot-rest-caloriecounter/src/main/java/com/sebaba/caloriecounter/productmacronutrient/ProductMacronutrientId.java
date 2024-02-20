package com.sebaba.caloriecounter.productmacronutrient;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class ProductMacronutrientId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "macronutrient_id")
	private Integer macronutrientId;

	
	public ProductMacronutrientId() {}

	public ProductMacronutrientId(Long productId, Integer macronutrientId) {
		this.productId = productId;
		this.macronutrientId = macronutrientId;
	}

	public Long getProductId() {
		return productId;
	}

	public Integer getMacronutrientId() {
		return macronutrientId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(macronutrientId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		ProductMacronutrientId other = (ProductMacronutrientId) obj;
		return Objects.equals(macronutrientId, other.macronutrientId) && Objects.equals(productId, other.productId);
	}
	
}