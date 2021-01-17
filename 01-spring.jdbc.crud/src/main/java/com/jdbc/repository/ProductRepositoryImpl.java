package com.jdbc.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jdbc.model.Product;
import com.jdbc.rowmapper.ProductRowMapper;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private JdbcTemplate jdbcTemplate;

	//constructor injection w/out autowired
	public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

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

	@Override
	public boolean save(Product product) {
		final String sorgu = "INSERT INTO product(productId, name, price, available, addDate) VALUES(?,?,?,?,?)";

		try {

			this.jdbcTemplate.update(sorgu, new Object[] { product.getProductId(), product.getName(),
					product.getPrice(), product.getAvailable(), product.getAddDate() });

		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean saveBatch(List<Product> products) {

		final String sorgu = "INSERT INTO product(productId, name, price, available, addDate) VALUES(?,?,?,?,?)";

		try {

			this.jdbcTemplate.batchUpdate(sorgu, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {

					Product product = products.get(i);

					ps.setInt(1, product.getProductId());
					ps.setString(2, product.getName());
					ps.setDouble(3, product.getPrice());
					ps.setInt(4, product.getAvailable());
					ps.setTimestamp(5, Timestamp.from(product.getAddDate().toInstant()));
				}

				@Override
				public int getBatchSize() {
					return products.size();
				}
			});
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Product findById(final int id) {

		String sorgu = "SELECT * FROM product WHERE productId = ?";

		Product product = null;

		try {
			product = this.jdbcTemplate.queryForObject(sorgu, new Object[] { id }, new ProductRowMapper());

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> findProducts() {

		String sorgu = "SELECT * FROM product";

		List<Product> products = null;

		try {
			products = this.jdbcTemplate.query(sorgu, new ProductRowMapper());

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	@Override
	public boolean update(Product product) {
		
		String sorgu = "UPDATE product SET name = ?, price = ?, available = ? WHERE productId = ?";
		
		try {
			this.jdbcTemplate.update(sorgu, new Object[] {product.getName(), product.getPrice(), product.getAvailable(), product.getProductId()});
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteById(int id) {
		
		String sorgu = "DELETE FROM product WHERE productId = ?";
		
		try {	
			this.jdbcTemplate.update(sorgu, new Object[] {id});
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

//execute: sql'in üzerinde işlem yapılmadan gönderilecek sorgular için. 
//update: tablo içerisindeki güncellemeler için.