package com.sebaba.caloriecounter.person;

import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

	public RetrievePersonDTO toRetrievePersonDTO(Person person) {
		return new RetrievePersonDTO(
				person.getFirstName(),
				person.getFirstName(),
				person.getGender(),
				person.getDateOfBirth(),
				person.getHeight(),
				person.getWeight()
				);
	}
	
	
	public Person toPerson(CreatePersonDTO createPersonDTO) {
		return new Person(
				createPersonDTO.firstName(), 
				createPersonDTO.lastName(), 
				createPersonDTO.gender(), 
				createPersonDTO.dateOfBirth(), 
				createPersonDTO.height(), 
				createPersonDTO.weight()
				);
	}
	
}