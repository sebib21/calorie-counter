package com.sebaba.caloriecounter.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.core.exception.CategoryNotFoundException;

@Service
class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final CategoryMapper categoryMapper;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
		this.categoryRepository = categoryRepository;
		this.categoryMapper = categoryMapper;
	}

	
	@Override
	public List<RetrieveCategoryDTO> findAllCategories() {
		return categoryRepository
				.findAll()
				.stream()
				.map(categoryMapper::toRetrieveCategoryDTO)
				.collect(Collectors.toList());
	}

	@Override
	public RetrieveCategoryDTO findCategoryById(Integer id) {
		return categoryRepository
				.findById(id)
				.map(categoryMapper::toRetrieveCategoryDTO)
				.orElseThrow(CategoryNotFoundException::new);
	}
	
}