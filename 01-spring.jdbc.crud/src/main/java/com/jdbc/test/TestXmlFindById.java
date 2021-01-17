package com.jdbc.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.model.Product;
import com.jdbc.repository.ProductRepository;
import com.jdbc.repository.ProductRepositoryImpl;

public class TestXmlFindById {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ProductRepository productRepository = applicationContext.getBean("productRepositoryImpl",
				ProductRepositoryImpl.class);

		Product product = productRepository.findById(102);

		System.out.println(product);

		applicationContext.close();
	}
}
