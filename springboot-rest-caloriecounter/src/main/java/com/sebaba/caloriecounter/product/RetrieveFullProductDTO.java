package com.sebaba.caloriecounter.product;

import java.util.List;

import com.sebaba.caloriecounter.productmacronutrient.RetrieveProductMacronutrientDTO;
import com.sebaba.caloriecounter.productmicronutrient.RetrieveProductMicronutrientDTO;

public record RetrieveFullProductDTO(
		RetrieveProductDTO productPrimaryInfo,
		List<RetrieveProductMacronutrientDTO> productMacronutrientList,
		List<RetrieveProductMicronutrientDTO> productMicronutrientList
){}