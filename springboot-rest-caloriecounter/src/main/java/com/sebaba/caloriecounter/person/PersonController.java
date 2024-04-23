package com.sebaba.caloriecounter.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/persons")
class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	
	@GetMapping("/{personId}")
	RetrievePersonDTO findPersonInfoById(@PathVariable Long personId) {
		return personService.findPersonInfoById(personId);
	}
	
	@PostMapping
	void savePerson(@Valid @RequestBody CreatePersonDTO createPersonDTO) {
		personService.savePerson(createPersonDTO);
	}
	
}