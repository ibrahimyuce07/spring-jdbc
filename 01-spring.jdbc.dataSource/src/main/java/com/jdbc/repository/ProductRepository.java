package com.jdbc.repository;

import java.util.List;

import com.jdbc.model.Product;

public interface ProductRepository {

	boolean createProductTable();
	
	boolean save(Product product);
	
	boolean saveBatch(List<Product> products);
	
	Product findById(int id);
	
	List<Product> findProducts();
	
}
