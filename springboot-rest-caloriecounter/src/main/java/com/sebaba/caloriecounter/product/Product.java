package com.sebaba.caloriecounter.product;

import java.util.List;

import com.sebaba.caloriecounter.category.Category;
import com.sebaba.caloriecounter.mealcontent.MealContent;
import com.sebaba.caloriecounter.productmacronutrient.ProductMacronutrient;
import com.sebaba.caloriecounter.productmicronutrient.ProductMicronutrient;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "barcode")
	private String barcode;
	
	@Column(name = "name")
	private String name;

	@Column(name = "kilocalories")
	private Double kilocalories;
	
	@Column(name = "verified")
	private boolean verified;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	private List<ProductMacronutrient> productMacronutrientList;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	private List<ProductMicronutrient> productMicronutrientList;
	
	@OneToMany(mappedBy = "product")
	private List<MealContent> mealContentList;
	
	
	public Product() {}

	public Product(String barcode, String name, Double kilocalories) {
		this.barcode = barcode;
		this.name = name;
		this.kilocalories = kilocalories;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getKilocalories() {
		return kilocalories;
	}

	public void setKilocalories(Double kilocalories) {
		this.kilocalories = kilocalories;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductMacronutrient> getProductMacronutrientList() {
		return productMacronutrientList;
	}

	public void setProductMacronutrientList(List<ProductMacronutrient> productMacronutrientList) {
		this.productMacronutrientList = productMacronutrientList;
	}

	public List<ProductMicronutrient> getProductMicronutrientList() {
		return productMicronutrientList;
	}

	public void setProductMicronutrientList(List<ProductMicronutrient> productMicronutrientList) {
		this.productMicronutrientList = productMicronutrientList;
	}

	public List<MealContent> getMealContentList() {
		return mealContentList;
	}

	public void setMealContentList(List<MealContent> mealContentList) {
		this.mealContentList = mealContentList;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", barcode=" + barcode + ", name=" + name + ", kilocalories="
				+ kilocalories + "]";
	}
	
}