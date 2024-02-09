package com.sebaba.caloriecounter.productmicronutrient;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
class ProductMicronutrientId implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "micronutrient_id")
	private Integer micronutrientId;

	
	public ProductMicronutrientId() {}

	public ProductMicronutrientId(Long productId, Integer micronutrientId) {
		this.productId = productId;
		this.micronutrientId = micronutrientId;
	}

	public Long getProductId() {
		return productId;
	}

	public Integer getMacronutrientId() {
		return micronutrientId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(micronutrientId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		ProductMicronutrientId other = (ProductMicronutrientId) obj;
		return Objects.equals(micronutrientId, other.micronutrientId) && Objects.equals(productId, other.productId);
	}
	
}