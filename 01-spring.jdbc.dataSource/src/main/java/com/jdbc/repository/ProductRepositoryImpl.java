package com.jdbc.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean createProductTable() {

		final String query = "CREATE TABLE product(productId INT NOT NULL, name VARCHAR(20), price DOUBLE, available INT, addDate DATETIME, PRIMARY KEY(productId))";

		try {
			this.jdbcTemplate.execute(query);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}


//execute: sql'in üzerinde işlem yapılmadan gönderilecek sorgular için. 
//