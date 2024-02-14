package com.sebaba.caloriecounter.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sebaba.caloriecounter.core.exception.ProductNotFoundException;

@Service
class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	
	@Override
	public List<RetrieveProductDTO> findAllProducts() {
		return productRepository
				.findAll()
				.stream()
				.map(productMapper::toRetrieveProductDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<RetrieveProductDTO> findProductsByNameLike(String namePart) {
		return productRepository
				.findByNameContaining(namePart)
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
		Product product = productRepository.save(productMapper.toProduct(createProductDTO));
		System.out.println(product);
	}

}