package com.sebaba.caloriecounter.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByNameContaining(String namePart);
	
}