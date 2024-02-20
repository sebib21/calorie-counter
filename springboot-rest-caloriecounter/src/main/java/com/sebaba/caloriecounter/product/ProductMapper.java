package com.sebaba.caloriecounter.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.category.Category;
import com.sebaba.caloriecounter.category.CategoryService;
import com.sebaba.caloriecounter.macronutrient.Macronutrient;
import com.sebaba.caloriecounter.macronutrient.MacronutrientService;
import com.sebaba.caloriecounter.micronutrient.Micronutrient;
import com.sebaba.caloriecounter.micronutrient.MicronutrientService;
import com.sebaba.caloriecounter.productmacronutrient.ProductMacronutrient;
import com.sebaba.caloriecounter.productmacronutrient.RetrieveProductMacronutrientDTO;
import com.sebaba.caloriecounter.productmicronutrient.ProductMicronutrient;
import com.sebaba.caloriecounter.productmicronutrient.RetrieveProductMicronutrientDTO;

@Service
public class ProductMapper {

	private final CategoryService categoryService;
	private final MacronutrientService macronutrientService;
	private final MicronutrientService micronutrientService;
	
	public ProductMapper(CategoryService categoryService, MacronutrientService macronutrientService, 
			MicronutrientService micronutrientService) {
		this.categoryService = categoryService;
		this.macronutrientService = macronutrientService;
		this.micronutrientService = micronutrientService;
	}

	
	public RetrieveProductDTO toRetrieveProductDTO(Product product) {
		return new RetrieveProductDTO(
				product.getProductId(),
				product.getBarcode(),
				product.getName(),
				product.getKilocalories(),
				product.isVerified(),
				product.getCategory().getName()
			);
	}
	
	public RetrieveFullProductDTO toRetrieveFullProductDTO(Product product) {
		return new RetrieveFullProductDTO(
				toRetrieveProductDTO(product),
				product.getProductMacronutrientList()
						.stream()
						.map(productMacronutrient -> new RetrieveProductMacronutrientDTO(
								productMacronutrient.getMacronutrient().getNutrient(),
								productMacronutrient.getContent()
							)
						  )
						.collect(Collectors.toList()),
				product.getProductMicronutrientList()
						.stream()
						.map(productMicronutrient -> new RetrieveProductMicronutrientDTO(
								productMicronutrient.getMicronutrient().getNutrient(),
								productMicronutrient.getContent()
							)
						 )
						.collect(Collectors.toList())
			);
	}
	
	public Product toProduct(CreateProductDTO createProductDTO) {
	
		Product product = new Product(
				createProductDTO.barcode(), 
				createProductDTO.name(), 
				createProductDTO.kilocalories());
		
		// set category
		if(categoryService.findCategoryById(createProductDTO.categoryId()) != null){
			Category category = new Category();
			category.setCategoryId(createProductDTO.categoryId());
			product.setCategory(category);
		}
		
		
		// set macronutrients
		List<ProductMacronutrient> productMacronutrientList = new ArrayList<>();
		createProductDTO.productMacronutrientList()
			.forEach(productMacronutrient -> {
				Macronutrient macronutrient = macronutrientService.findMacronutrientById(productMacronutrient.macronutrientId());
				productMacronutrientList.add(new ProductMacronutrient(product, macronutrient, productMacronutrient.content()));
		});
		
		product.setProductMacronutrientList(productMacronutrientList);
		
		
		// set micronutrients
		List<ProductMicronutrient> productMicronutrientList = new ArrayList<>();
		createProductDTO.productMicronutrientList()
			.forEach(productMicronutrient -> {
				Micronutrient micronutrient = micronutrientService.findMicronutrientById(productMicronutrient.micronutrientId());
				productMicronutrientList.add(new ProductMicronutrient(product, micronutrient, productMicronutrient.content()));
			});
		
		product.setProductMicronutrientList(productMicronutrientList);
		
		return product;
	}

}