package com.sebaba.caloriecounter.person;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.core.exception.PersonNotFoundException;

@Service
class PersonServiceImpl implements PersonService{

	private final PersonRepository personRepository;
	private final PersonMapper personMapper;
	
	public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
		this.personRepository = personRepository;
		this.personMapper = personMapper;
	}


	@Override
	public RetrievePersonDTO findPersonInfoById(Long personId) {
		return personRepository
				.findById(personId)
				.map(personMapper::toRetrievePersonDTO)
				.orElseThrow(PersonNotFoundException::new);
	}


	@Override
	public void savePerson(CreatePersonDTO createPersonDTO) {
		personRepository.save(personMapper.toPerson(createPersonDTO));
	}
	
}