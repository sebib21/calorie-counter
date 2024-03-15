package com.sebaba.caloriecounter.objective;

import org.springframework.stereotype.Service;

@Service
class ObjectiveServiceImpl implements ObjectiveService{

	private final ObjectiveRepository objectiveRepository;
	private final ObjectiveMapper objectiveMapper;
	
	public ObjectiveServiceImpl(ObjectiveRepository objectiveRepository, ObjectiveMapper objectiveMapper) {
		this.objectiveRepository = objectiveRepository;
		this.objectiveMapper = objectiveMapper;
	}
	
	
	@Override
	public RetrieveObjectiveDTO findObjectiveById() {
		return null;
	}

	@Override
	public void saveObjective(CreateUpdateObjectiveDTO createUpdateObjectiveDTO) {
		objectiveRepository.save(objectiveMapper.toObjective(createUpdateObjectiveDTO));
	}

}