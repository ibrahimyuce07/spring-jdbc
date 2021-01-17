package com.jdbc.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.model.Product;
import com.jdbc.repository.ProductRepository;
import com.jdbc.repository.ProductRepositoryImpl;

public class TestXmlUpdate {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ProductRepository productRepository = applicationContext.getBean("productRepositoryImpl",
				ProductRepositoryImpl.class);

		Product product =  productRepository.findById(100);
		System.out.println(product);
		
		product.setAvailable(4);
		product.setPrice(3700);
		
		boolean sonuc = productRepository.update(product);
		
		if (sonuc) {
			System.out.println("Ürün güncellendi.");
		}else {
			System.out.println("Hata oluştu.");
		}
		
		applicationContext.close();
	}
}
