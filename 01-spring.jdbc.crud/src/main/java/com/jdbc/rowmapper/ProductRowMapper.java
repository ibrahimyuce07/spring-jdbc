package com.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.jdbc.model.Product;

public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		int productId = rs.getInt("productId");
		String name = rs.getString("name");
		double price = rs.getDouble("price");
		int available = rs.getInt("available");
		Date addDate = rs.getDate("addDate");

		Product p = new Product(productId, name, price, available, addDate);

		return p;
	}

}
