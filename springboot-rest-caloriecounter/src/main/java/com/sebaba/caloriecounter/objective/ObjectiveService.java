package com.sebaba.caloriecounter.objective;

public interface ObjectiveService {

	public RetrieveObjectiveDTO findObjectiveById();
	
	public void saveObjective(CreateUpdateObjectiveDTO createObjectiveDTO);
	
}