package com.shop.bridge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shop.bridge.pojo.Products;
import com.shop.bridge.repository.ProductRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRespository productRespository;

	public List<Products> findAll() {
		return productRespository.findAll();
	}

	public Optional<Products> findById(Long id) {
		return productRespository.findById(id);
	}

	public Products save(Products product) {
		return productRespository.save(product);
	}

	public void deleteById(Long id) {
		productRespository.deleteById(id);
	}
}
