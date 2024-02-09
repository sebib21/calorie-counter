package com.sebaba.caloriecounter.mealcontent;

import com.sebaba.caloriecounter.meal.Meal;
import com.sebaba.caloriecounter.product.Product;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "MealContent")
@Table(name = "meal_content")
public class MealContent {

	@EmbeddedId
	private MealContentId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("mealId")
	@JoinColumn(name = "meal_id")
	private Meal meal;
	
	@Column(name = "serving_size")
	private Double servingSize;

	
	public MealContent() {}

	public MealContent(Product product, Meal meal, Double servingSize) {
		this.id = new MealContentId(product.getProductId(), meal.getMealId());
		this.product = product;
		this.meal = meal;
		this.servingSize = servingSize;
	}

	public MealContentId getId() {
		return id;
	}

	public void setId(MealContentId id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Double getServingSize() {
		return servingSize;
	}

	public void setServingSize(Double servingSize) {
		this.servingSize = servingSize;
	}

	@Override
	public String toString() {
		return "MealContent [id=" + id + ", product=" + product + ", meal=" + meal + ", servingSize=" + servingSize
				+ "]";
	}
	
}