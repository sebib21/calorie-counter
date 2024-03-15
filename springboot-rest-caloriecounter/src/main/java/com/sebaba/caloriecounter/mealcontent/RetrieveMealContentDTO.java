package com.sebaba.caloriecounter.mealcontent;

import com.sebaba.caloriecounter.product.RetrieveFullProductDTO;

public record RetrieveMealContentDTO(
		Long mealId,
		RetrieveFullProductDTO product,
		Double servingSize
){}