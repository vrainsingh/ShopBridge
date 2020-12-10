package com.shop.bridge.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.bridge.pojo.GenericResponse;
import com.shop.bridge.pojo.Products;
import com.shop.bridge.service.ProductService;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public ResponseEntity<GenericResponse> findAll() {
		List<Products> products = productService.findAll();

		return ResponseEntity.ok(new GenericResponse(products));
	}

	@PostMapping
	public ResponseEntity<GenericResponse> create(@Valid @RequestBody Products product) {
		return ResponseEntity.ok(new GenericResponse(productService.save(product)));
	}

	@GetMapping("/{id}")
	public ResponseEntity<GenericResponse> findById(@PathVariable Long id) {
		Optional<Products> stock = productService.findById(id);
		if (!stock.isPresent()) {
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(new GenericResponse(stock));
	}

	@GetMapping("/check")
	public ResponseEntity<GenericResponse> findById() {
		return ResponseEntity.ok(new GenericResponse(null));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<GenericResponse> delete(@PathVariable Long id) {
		if (!productService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}
		productService.deleteById(id);
		return ResponseEntity.ok(new GenericResponse(null));
	}

}
