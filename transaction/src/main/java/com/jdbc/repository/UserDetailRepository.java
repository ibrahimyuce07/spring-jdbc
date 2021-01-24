package com.jdbc.repository;

import java.util.List;

import com.jdbc.model.UserDetail;

public interface UserDetailRepository {

	boolean save(int userId, UserDetail userDetail);
	
	boolean update(UserDetail userDetail);
	
	boolean findById(int id);
	
	List<UserDetail> findUserDetails();
	
}
