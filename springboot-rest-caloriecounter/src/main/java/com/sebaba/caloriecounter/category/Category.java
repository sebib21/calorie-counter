package com.sebaba.caloriecounter.category;

import java.util.List;

import com.sebaba.caloriecounter.product.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Category")
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer categoryId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "icon_url")
	private String iconURL;

	@OneToMany(mappedBy = "category")
	private List<Product> productList;
	
	
	public Category() {}

	public Category(String name, String iconURL) {
		this.name = name;
		this.iconURL = iconURL;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", iconURL=" + iconURL + "]";
	}
	
}