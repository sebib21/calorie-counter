package com.sebaba.caloriecounter.category;

public record RetrieveCategoryDTO(
		Integer categoryId,
		String name,
		String iconURL
){}