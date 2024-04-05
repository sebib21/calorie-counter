package com.sebaba.caloriecounter.category;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	
	@GetMapping
	List<RetrieveCategoryDTO> findAllCategories(){
		return categoryService.findAllCategories();
	}
	
	@GetMapping("/{categoryId}")
	RetrieveCategoryDTO findCategoryById(@PathVariable Integer categoryId) {
		return categoryService.findCategoryById(categoryId);
	}
	
}