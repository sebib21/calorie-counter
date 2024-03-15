package com.sebaba.caloriecounter.product;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@GetMapping
	public List<RetrieveProductDTO> findFirst20Products() {
		return productService.findFirst20Products();
	}
	
	@GetMapping("/search/{prodName}")
	public List<RetrieveProductDTO> findFirst10ByNameContaining(@PathVariable String prodName) {
		return productService.findFirst10ByNameContaining(prodName);
	}
	
	@GetMapping("bycategory/{categoryId}")
	public List<RetrieveProductDTO> findFirst10ProductsByCatrgoryId(@PathVariable Integer categoryId) {
		return productService.findFirstXProductsByCatrgoryId(categoryId, 10);
	}
	
	@GetMapping("/{productId}")
	public RetrieveFullProductDTO findProductById(@PathVariable Long productId) {
		return productService.findProductById(productId);
	}
	
	@PostMapping
	public void saveProduct(@Valid @RequestBody CreateProductDTO createProductDTO) {
		productService.saveProduct(createProductDTO);
	}
	
}