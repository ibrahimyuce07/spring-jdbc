package com.jdbc.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jdbc.model.User;

public class UserRepositoryImpl extends NamedParameterJdbcDaoSupport implements UserRepository {

	@Override
	public boolean save(User user) {
		
		String query = "INSERT INTO user(userId, username, password, creationDate) "
				+ "VALUES(:userId, :username, :password, :creationDate)";
		
		try {
			SqlParameterSource source = new MapSqlParameterSource("userId", user.getUserId())
					.addValue("username", user.getUsername())
					.addValue("password", user.getPassword())
					.addValue("creationDate", user.getCreationDate());
			this.getNamedParameterJdbcTemplate().update(query, source);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(User user) {

		String query = "UPDATE user SET username = :username, password = :password WHERE userId = :userId";
		
		try {
			SqlParameterSource source = new MapSqlParameterSource("username", user.getUsername())
					.addValue("password", user.getPassword())
					.addValue("userId", user.getUserId());
			
			this.getNamedParameterJdbcTemplate().update(query, source);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findWithUserDetailById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
