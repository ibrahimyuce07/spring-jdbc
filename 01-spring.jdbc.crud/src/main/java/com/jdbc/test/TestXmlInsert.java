package com.jdbc.test;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.model.Product;
import com.jdbc.repository.ProductRepository;
import com.jdbc.repository.ProductRepositoryImpl;

public class TestXmlInsert {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ProductRepository productRepository = applicationContext.getBean("productRepositoryImpl",
				ProductRepositoryImpl.class);

		Product product = new Product(100, "Iphone 7", 3500, 6, new Date());

		productRepository.save(product);

		applicationContext.close();
	}

}
