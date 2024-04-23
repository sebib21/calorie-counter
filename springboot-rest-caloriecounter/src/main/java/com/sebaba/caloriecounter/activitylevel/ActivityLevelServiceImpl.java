package com.sebaba.caloriecounter.activitylevel;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.core.exception.ActivityLevelNotFoundException;

@Service
class ActivityLevelServiceImpl implements ActivityLevelService {

	private final ActivityLevelRepository activityLevelRepository;
	private final ActivityLevelMapper activityLevelMapper;
	
	public ActivityLevelServiceImpl(ActivityLevelRepository activityLevelRepository,
			ActivityLevelMapper activityLevelMapper) {
		this.activityLevelRepository = activityLevelRepository;
		this.activityLevelMapper = activityLevelMapper;
	}

	
	@Override
	public List<RetrieveActivityLevelDTO> findAllActivityLevels() {
		return activityLevelRepository
				.findAll()
				.stream()
				.map(activityLevelMapper::toRetrieveActivityLevelDTO)
				.collect(Collectors.toList());
	}

	@Override
	public RetrieveActivityLevelDTO findActivityLevelById(Integer activityLevelId) {
		return activityLevelRepository
				.findById(activityLevelId)
				.map(activityLevelMapper::toRetrieveActivityLevelDTO)
				.orElseThrow(ActivityLevelNotFoundException::new);
	}

}