package com.jdbc.repository;

import java.util.List;

import com.jdbc.model.User;

public interface UserRepository {

	boolean save(User user);
	
	boolean update(User user);
	
	boolean deleteById(int id);
	
	User findbyId(int id);
	
	User findWithUserDetailById(int id);
	
	List<User> findUsers();
}
