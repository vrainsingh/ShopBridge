package com.shop.bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.bridge.pojo.Products;


@Repository
public interface ProductRespository extends JpaRepository<Products, Long> {
}
