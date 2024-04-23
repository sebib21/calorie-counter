package com.sebaba.caloriecounter.person;

public interface PersonService {

	public RetrievePersonDTO findPersonInfoById(Long personId);
	
	public void savePerson(CreatePersonDTO createPersonDTO);
	
}