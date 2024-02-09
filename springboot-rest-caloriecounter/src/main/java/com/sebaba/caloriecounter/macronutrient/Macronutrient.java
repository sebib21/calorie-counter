package com.sebaba.caloriecounter.macronutrient;

import java.util.List;

import com.sebaba.caloriecounter.productmacronutrient.ProductMacronutrient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Macronutrient")
@Table(name = "macronutrient")
public class Macronutrient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "macronutrient_id")
	private Integer macronutrientId;
	
	@Column(name = "nutrient")
	private String nutrient;
	
	@Column(name = "kcal_per_gram")
	private Byte kcalPerGram;
	
	@OneToMany
	@JoinColumn(name = "macronutrient_id")
	private List<ProductMacronutrient> productMacronutrientList;
	
	
	public Macronutrient() {}

	public Macronutrient(String nutrient, Byte kcalPerGram) {
		this.nutrient = nutrient;
		this.kcalPerGram = kcalPerGram;
	}

	public Integer getMacronutrientId() {
		return macronutrientId;
	}

	public void setMacronutrientId(Integer macronutrientId) {
		this.macronutrientId = macronutrientId;
	}

	public String getNutrient() {
		return nutrient;
	}

	public void setNutrient(String nutrient) {
		this.nutrient = nutrient;
	}

	public Byte getKcalPerGram() {
		return kcalPerGram;
	}

	public void setKcalPerGram(Byte kcalPerGram) {
		this.kcalPerGram = kcalPerGram;
	}
	
	public List<ProductMacronutrient> getProductMacronutrientList() {
		return productMacronutrientList;
	}

	public void setProductMacronutrientList(List<ProductMacronutrient> productMacronutrientList) {
		this.productMacronutrientList = productMacronutrientList;
	}

	@Override
	public String toString() {
		return "Macronutrient [macronutrientId=" + macronutrientId + ", nutrient=" + nutrient + ", kcalPerGram="
				+ kcalPerGram + "]";
	}
	
}