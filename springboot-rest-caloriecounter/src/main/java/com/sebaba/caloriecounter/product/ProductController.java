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
	public List<RetrieveProductDTO> findAllProducts() {
		return productService.findAllProducts();
	}
	
	@GetMapping("/search/{prodName}")
	public List<RetrieveProductDTO> findProductsByNameLike(@PathVariable String prodName) {
		return productService.findProductsByNameLike(prodName);
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