package com.sebaba.caloriecounter.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findTop20ByOrderByProductIdAsc();
	
	public List<Product> findTop10ByNameContainingOrderByProductIdAsc(String namePart);

	@Query(value = "SELECT product_id, barcode, name, kilocalories, verified, category_id FROM product "
				 + "WHERE category_id = :categoryId ORDER BY product_id ASC LIMIT :limit", 
		   nativeQuery = true)
	public List<Product> findTopXProductsByCatrgoryId(Integer categoryId, int limit);
	
}