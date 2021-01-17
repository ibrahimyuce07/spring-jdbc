package com.jdbc.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.model.Product;
import com.jdbc.repository.ProductRepository;
import com.jdbc.repository.ProductRepositoryImpl;

public class TestXmlBatchInsert {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ProductRepository productRepository = applicationContext.getBean("productRepositoryImpl",
				ProductRepositoryImpl.class);

		Product product1 = new Product(101, "Samsung Galaxy S7", 3200, 2, new Date());
		Product product2 = new Product(102, "Apple Iphone 8", 5500, 5, new Date());
		Product product3 = new Product(103, "Asus Zenfone", 2500, 8, new Date());

		List<Product> products = Arrays.asList(product1, product2, product3);

		productRepository.saveBatch(products);

		applicationContext.close();
	}
}
