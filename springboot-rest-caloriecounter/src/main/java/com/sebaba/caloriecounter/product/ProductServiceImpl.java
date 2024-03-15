package com.sebaba.caloriecounter.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.core.exception.ProductNotFoundException;

@Service
class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}
	

	@Override
	public List<RetrieveProductDTO> findFirst20Products() {
		return productRepository
				.findTop20ByOrderByProductIdAsc()
				.stream()
				.map(productMapper::toRetrieveProductDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<RetrieveProductDTO> findFirst10ByNameContaining(String namePart) {
		return productRepository
				.findTop10ByNameContainingOrderByProductIdAsc(namePart)
				.stream()
				.map(productMapper::toRetrieveProductDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<RetrieveProductDTO> findFirstXProductsByCatrgoryId(Integer categoryId, int limit) {
		return productRepository
				.findTopXProductsByCatrgoryId(categoryId, limit)
				.stream()
				.map(productMapper::toRetrieveProductDTO)
				.collect(Collectors.toList());
	}

	@Override
	public RetrieveFullProductDTO findProductById(Long productId) {
		return productRepository
				.findById(productId)
				.map(productMapper::toRetrieveFullProductDTO)
				.orElseThrow(ProductNotFoundException::new);
	}
	
	@Override
	public void saveProduct(CreateProductDTO createProductDTO) {
		productRepository.save(productMapper.toProduct(createProductDTO));
	}

}