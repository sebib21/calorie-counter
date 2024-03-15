package com.sebaba.caloriecounter.product;

import java.util.List;

public interface ProductService {
	
	public List<RetrieveProductDTO> findFirst20Products();
	
	public List<RetrieveProductDTO> findFirst10ByNameContaining(String namePart);	

	public List<RetrieveProductDTO> findFirstXProductsByCatrgoryId(Integer categoryId, int limit);

	public RetrieveFullProductDTO findProductById(Long productId);
	
	public void saveProduct(CreateProductDTO createProductDTO);
	
}