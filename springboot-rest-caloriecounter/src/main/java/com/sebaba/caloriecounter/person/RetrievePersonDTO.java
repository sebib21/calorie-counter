package com.sebaba.caloriecounter.person;

import java.time.LocalDate;

record RetrievePersonDTO(
		String firstName,
		String lastName,
		String gender,
		LocalDate dateOfBirth,
		Double height,
		Double weight,
		String activityLevelDescription
){}