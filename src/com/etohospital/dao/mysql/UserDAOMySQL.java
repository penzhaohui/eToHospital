package com.etohospital.dao.mysql;

import java.util.List;

import com.etohospital.dao.UserDAO;
import com.etohospital.model.UserModel;

public class UserDAOMySQL extends BaseDAOMySQL<UserModel> implements UserDAO {
	
	@Override
	public int insertUser(UserModel user, int userId) throws Exception {
		
		return super.genericInsert(user, userId);
	}

	@Override
	public int updateUser(UserModel user, int userId) throws Exception {
		
		return genericUpdate(user, userId);
	}

	@Override
	public int deleteUser(UserModel user, int userId) throws Exception {
		
		return genericDelete(user, userId);
	}

	@Override
	public List<UserModel> getUser(UserModel user, int userId) throws Exception {
		
		return genericQuery(user, userId);
	}
}
