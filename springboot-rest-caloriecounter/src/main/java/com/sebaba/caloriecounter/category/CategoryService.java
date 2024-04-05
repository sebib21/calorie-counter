package com.sebaba.caloriecounter.category;

import java.util.List;

public interface CategoryService {

	public List<RetrieveCategoryDTO> findAllCategories();
	
	public RetrieveCategoryDTO findCategoryById(Integer categoryId);
	
}