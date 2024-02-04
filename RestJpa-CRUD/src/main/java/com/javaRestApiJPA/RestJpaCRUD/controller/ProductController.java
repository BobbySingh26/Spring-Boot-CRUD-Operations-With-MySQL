package com.javaRestApiJPA.RestJpaCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaRestApiJPA.RestJpaCRUD.entity.Product;
import com.javaRestApiJPA.RestJpaCRUD.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addproducts")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	@GetMapping("/allproducts")
	public List<Product> findAllProduct() {
		return service.getProduct();
	}
	
	@GetMapping("/productbyid/{id}")
	public Product findProductById(@PathVariable int id) {
		return service.getProductById(id);
	}
	
	@GetMapping("/productbyname/{name}")
	public List<Product> findProductById(@PathVariable String name) {
		return service.getProductName(name);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
