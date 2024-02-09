package com.sebaba.caloriecounter.productmacronutrient;

import com.sebaba.caloriecounter.macronutrient.Macronutrient;
import com.sebaba.caloriecounter.product.Product;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "ProductMacronutrient")
@Table(name = "product_macronutrient")
public class ProductMacronutrient {

	@EmbeddedId
	private ProductMacronutrientId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("macronutrientId")
	@JoinColumn(name = "macronutrient_id")
	private Macronutrient macronutrient;
	
	@Column(name = "content")
	private Double content;

	
	public ProductMacronutrient() {}

	public ProductMacronutrient(Product product, Macronutrient macronutrient, Double content) {
		this.id = new ProductMacronutrientId(product.getProductId(), macronutrient.getMacronutrientId());
		this.product = product;
		this.macronutrient = macronutrient;
		this.content = content;
	}

	public ProductMacronutrientId getId() {
		return id;
	}

	public void setId(ProductMacronutrientId id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Macronutrient getMacronutrient() {
		return macronutrient;
	}

	public void setMacronutrient(Macronutrient macronutrient) {
		this.macronutrient = macronutrient;
	}

	public Double getContent() {
		return content;
	}

	public void setContent(Double content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ProductMacronutrient [id=" + id + ", product=" + product + ", macronutrient=" + macronutrient
				+ ", content=" + content + "]";
	}
	
}