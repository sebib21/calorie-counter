package com.sebaba.caloriecounter.activitylevel;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/activitylevels")
public class ActivityLevelController {

	private final ActivityLevelService activityLevelService;

	public ActivityLevelController(ActivityLevelService activityLevelService) {
		this.activityLevelService = activityLevelService;
	}
	
	
	@GetMapping
	public List<RetrieveActivityLevelDTO> findAllActivityLevels() {
		return activityLevelService.findAllActivityLevels();
	}
	
}