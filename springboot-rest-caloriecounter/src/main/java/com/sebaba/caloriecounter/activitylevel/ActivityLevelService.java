package com.sebaba.caloriecounter.activitylevel;

import java.util.List;

public interface ActivityLevelService {

	public List<RetrieveActivityLevelDTO> findAllActivityLevels();
	
	public RetrieveActivityLevelDTO findActivityLevelById(Integer activityLevelId);
	
}