package com.sebaba.caloriecounter.product;

public record RetrieveProductDTO(
		Long productId,
		String barcode,
		String name,
		Double kilocalories,
		boolean verified,
		String categoryName
){}