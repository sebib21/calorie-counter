package com.sebaba.caloriecounter.activitylevel;

import org.springframework.stereotype.Service;

@Service
public class ActivityLevelMapper {
	
	public RetrieveActivityLevelDTO toRetrieveActivityLevelDTO(ActivityLevel activityLevel) {
		return new RetrieveActivityLevelDTO(
				activityLevel.getActivityLevelId(),
				activityLevel.getDescripion(),
				activityLevel.getMultiplier());
	}
	
}