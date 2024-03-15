package com.sebaba.caloriecounter.mealcontent;

import org.springframework.stereotype.Service;

@Service
class MealContentServiceImpl implements MealContentService {

	private final MealContentRepository mealContentRepository;
	private final MealContentMapper mealContentMapper;
	
	public MealContentServiceImpl(MealContentRepository mealContentRepository, MealContentMapper mealContentMapper) {
		this.mealContentRepository = mealContentRepository;
		this.mealContentMapper = mealContentMapper;
	}


	@Override
	public void saveOrUpdateMealContent(CreateUpdateMealContentDTO createUpdateMealContentDTO) {
		mealContentRepository.save(mealContentMapper.toMealContent(createUpdateMealContentDTO));
	}

	@Override
	public void deleteMealContent(Long productId, Long mealId) {
		mealContentRepository.deleteById(new MealContentId(productId, mealId));
	}
	
}