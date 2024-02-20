package com.sebaba.caloriecounter.product;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import com.sebaba.caloriecounter.core.validation.NamingValidation;
import com.sebaba.caloriecounter.productmacronutrient.CreateProductMacronutrientDTO;
import com.sebaba.caloriecounter.productmicronutrient.CreateProductMicronutrientDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CreateProductDTO(
		
		String barcode,
		
		@NamingValidation(minLength = 2, maxLength = 50, message = "The product name must be between 2 and 50 characters. "
			+ "Also without more than one whitespaces in a row or special characeters like '<>[]{};'.")
		String name,
		
		@Range(min = 1 ,max = 900, message = "The kilocalories range must be between 1 and 900!")
		Double kilocalories,
		
		@NotNull(message = "The product category must be specified!")
		Integer categoryId,
		
		@NotNull(message = "The macronutrients for the product need to be specified!")
		List<@Valid CreateProductMacronutrientDTO> productMacronutrientList,
		
		@NotNull(message = "The micronutrients for the product need to be specified!")
		List<@Valid CreateProductMicronutrientDTO> productMicronutrientList
		
){}