package com.javaRestApiJPA.RestJpaCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaRestApiJPA.RestJpaCRUD.entity.Product;
import com.javaRestApiJPA.RestJpaCRUD.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> getProduct(){
		return repository.findAll();
	}

	public Product getProductById(int id){
		return repository.findById(id).orElse(null);
	}

	public List<Product> getProductName(String name){
		return repository.findByName(name);
	}

	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "Product Removed Successfully: "+id;
	}

	public Product updateProduct(Product product) {
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
}
