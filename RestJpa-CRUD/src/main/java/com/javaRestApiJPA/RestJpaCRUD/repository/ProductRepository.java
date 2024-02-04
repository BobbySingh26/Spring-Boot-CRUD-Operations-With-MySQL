package com.javaRestApiJPA.RestJpaCRUD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaRestApiJPA.RestJpaCRUD.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByName(String name);
}
