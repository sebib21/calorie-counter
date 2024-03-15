package com.sebaba.caloriecounter.meal;

import java.time.LocalDate;
import java.util.List;

import com.sebaba.caloriecounter.mealcontent.RetrieveMealContentDTO;

public record RetrieveMealDTO(
		Long mealId,
		LocalDate mealDate,
		List<RetrieveMealContentDTO> mealContentList
){}