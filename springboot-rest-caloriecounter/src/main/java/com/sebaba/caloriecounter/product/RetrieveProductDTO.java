package com.sebaba.caloriecounter.product;

record RetrieveProductDTO(
		Long productId,
		String barcode,
		String name,
		Double kilocalories,
		boolean verified,
		String categoryName
){}