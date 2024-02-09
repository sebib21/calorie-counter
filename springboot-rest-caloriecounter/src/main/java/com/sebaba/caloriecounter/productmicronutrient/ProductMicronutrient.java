package com.sebaba.caloriecounter.productmicronutrient;

import com.sebaba.caloriecounter.micronutrient.Micronutrient;
import com.sebaba.caloriecounter.product.Product;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "ProductMicronutrient")
@Table(name = "product_micronutrient")
public class ProductMicronutrient {

	@EmbeddedId
	private ProductMicronutrientId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@MapsId("productId")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "micronutrient_id")
	@MapsId("micronutrientId")
	private Micronutrient micronutrient;
	
	@Column(name = "content")
	private Double content;

	
	public ProductMicronutrient() {}

	public ProductMicronutrient(Product product, Micronutrient micronutrient, Double content) {
		this.id = new ProductMicronutrientId(product.getProductId(), micronutrient.getMicronutrientId());
		this.product = product;
		this.micronutrient = micronutrient;
		this.content = content;
	}

	public ProductMicronutrientId getProductMicronutrientId() {
		return id;
	}

	public void setProductMicronutrientId(ProductMicronutrientId productMicronutrientId) {
		this.id = productMicronutrientId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Micronutrient getMicronutrient() {
		return micronutrient;
	}

	public void setMicronutrient(Micronutrient micronutrient) {
		this.micronutrient = micronutrient;
	}

	public Double getContent() {
		return content;
	}

	public void setContent(Double content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ProductMicronutrient [productMicronutrientId=" + id + ", product=" + product
				+ ", micronutrient=" + micronutrient + ", content=" + content + "]";
	}
	
}