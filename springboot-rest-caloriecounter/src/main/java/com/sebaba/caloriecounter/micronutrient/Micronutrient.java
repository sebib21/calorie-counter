package com.sebaba.caloriecounter.micronutrient;

import java.util.List;

import com.sebaba.caloriecounter.productmicronutrient.ProductMicronutrient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Micronutrient")
@Table(name = "micronutrient")
public class Micronutrient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "micronutrient_id")
	private Integer micronutrientId;
	
	@Column(name = "nutrient")
	private String nutrient;

	@Column(name = "type")
	private String type;

	@Column(name = "units")
	private String units;

	@Column(name = "men_rda")
	private Double menRDA;

	@Column(name = "women_rda")
	private Double womenRDA;

	@Column(name = "upper_limit")
	private Double upperLimit;

	@OneToMany(mappedBy = "micronutrient")
	private List<ProductMicronutrient> productMicronutrientList;
	
	
	public Micronutrient() {}

	public Micronutrient(String nutrient, String type, String units, Double menRDA, Double womenRDA,
			Double upperLimit) {
		this.nutrient = nutrient;
		this.type = type;
		this.units = units;
		this.menRDA = menRDA;
		this.womenRDA = womenRDA;
		this.upperLimit = upperLimit;
	}

	public Integer getMicronutrientId() {
		return micronutrientId;
	}

	public void setMicronutrientId(Integer micronutrientId) {
		this.micronutrientId = micronutrientId;
	}

	public String getNutrient() {
		return nutrient;
	}

	public void setNutrient(String nutrient) {
		this.nutrient = nutrient;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public Double getMenRDA() {
		return menRDA;
	}

	public void setMenRDA(Double menRDA) {
		this.menRDA = menRDA;
	}

	public Double getWomenRDA() {
		return womenRDA;
	}

	public void setWomenRDA(Double womenRDA) {
		this.womenRDA = womenRDA;
	}

	public Double getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(Double upperLimit) {
		this.upperLimit = upperLimit;
	}

	public List<ProductMicronutrient> getProductMicronutrientList() {
		return productMicronutrientList;
	}

	public void setProductMicronutrientList(List<ProductMicronutrient> productMicronutrientList) {
		this.productMicronutrientList = productMicronutrientList;
	}

	@Override
	public String toString() {
		return "Micronutrient [micronutrientId=" + micronutrientId + ", nutrient=" + nutrient + ", type=" + type
				+ ", units=" + units + ", menRDA=" + menRDA + ", womenRDA=" + womenRDA + ", upperLimit=" + upperLimit
				+ "]";
	}
	
}