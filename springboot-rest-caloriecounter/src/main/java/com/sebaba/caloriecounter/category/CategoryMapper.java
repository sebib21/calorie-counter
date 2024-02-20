package com.sebaba.caloriecounter.category;

import org.springframework.stereotype.Service;

@Service
class CategoryMapper {

	public RetrieveCategoryDTO toRetrieveCategoryDTO(Category category) {
		return new RetrieveCategoryDTO(
				category.getCategoryId(),
				category.getName(), 
				category.getIconURL());
	}

}