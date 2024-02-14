package com.sebaba.caloriecounter.product;

import java.util.List;

public interface ProductService {

	public List<RetrieveProductDTO> findAllProducts();
	
	public List<RetrieveProductDTO> findProductsByNameLike(String namePart);
	
	public RetrieveFullProductDTO findProductById(Long productId);
	
	public void saveProduct(CreateProductDTO createProductDTO);
	
}