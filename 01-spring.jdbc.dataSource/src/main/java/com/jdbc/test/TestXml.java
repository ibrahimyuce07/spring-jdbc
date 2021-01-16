package com.jdbc.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.repository.ProductRepository;
import com.jdbc.repository.ProductRepositoryImpl;

public class TestXml {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProductRepository productRepository = applicationContext.getBean("productRepositoryImpl", ProductRepositoryImpl.class);
		
		productRepository.createProductTable();
		
		
		applicationContext.close();
	}
}
