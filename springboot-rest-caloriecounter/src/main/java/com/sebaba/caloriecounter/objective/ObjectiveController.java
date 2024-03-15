package com.sebaba.caloriecounter.objective;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/objectives")
public class ObjectiveController {

	private final ObjectiveService objectiveService;

	public ObjectiveController(ObjectiveService objectiveService) {
		this.objectiveService = objectiveService;
	}
	
	
	@PostMapping
	public void saveObjective(@Valid @RequestBody CreateUpdateObjectiveDTO createUpdateObjectiveDTO) {
		objectiveService.saveObjective(createUpdateObjectiveDTO);
	}
	
}