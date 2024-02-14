package com.sebaba.caloriecounter.category;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	
	@GetMapping
	public List<RetrieveCategoryDTO> findAllCategories(){
		return categoryService.findAllCategories();
	}
	
	@GetMapping("/{id}")
	public RetrieveCategoryDTO findCategoryById(@PathVariable Integer id) {
		return categoryService.findCategoryById(id);
	}
	
}