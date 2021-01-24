package com.jdbc.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.jdbc.model.UserDetail;

public class UserDetailRepositoryImpl extends NamedParameterJdbcDaoSupport implements UserDetailRepository {

	@Override
	public boolean save(int userId, UserDetail userDetail) {
		
		
		return false;
	}

	@Override
	public boolean update(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserDetail> findUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
