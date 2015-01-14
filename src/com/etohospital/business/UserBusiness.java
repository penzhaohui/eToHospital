package com.etohospital.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etohospital.dao.UserDAO;
import com.etohospital.dao.mysql.UserDAOMySQL;
import com.etohospital.model.UserModel;
import com.etohospital.service.UserService;

public class UserBusiness implements UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	private static UserDAO userDAO = new UserDAOMySQL();
	
	// 以下代码确保客户端必须完全遵循接口中定义的方法
	private volatile static UserService singleton;
	private UserBusiness(){};
	public static UserService getSingleton() {
		if (singleton == null) {
			synchronized (UserBusiness.class) {
				if (singleton == null) {
					singleton = new UserBusiness();
				}
			}
		}		
		return singleton;
	}
	
	@Override
	public int insertUser(UserModel user, int userId) throws Exception {
		
		if(user.getUserID() > 0)
		{
			throw new IllegalArgumentException("Invalid user id value.");
		}
		
		int effectedRows = userDAO.insertUser(user, userId);
		
		if(logger.isDebugEnabled())
		{
			List<UserModel> users = userDAO.getUser(user, userId);
			logger.debug("Insert one User, the user id: " + users.get(0).getUserID());
		}
		
		return effectedRows;
	}

	@Override
	public int updateUser(UserModel user, int userId) throws Exception {
		
		if(user.getUserID() < 1)
		{
			throw new IllegalArgumentException("Invalid user id value.");
		}
		
		int effectedRows = userDAO.updateUser(user, userId);
		
		if(logger.isDebugEnabled())
		{			
			logger.debug("Update one User, the user id: " + user.getUserID());
		}
		
		return effectedRows;
	}

	@Override
	public int deleteUser(UserModel user, int userId) throws Exception {
		
		if(user.getUserID() < 1)
		{
			throw new IllegalArgumentException("Invalid user id value.");
		}
		
		int effectedRows = userDAO.deleteUser(user, userId);
		
		if(logger.isDebugEnabled())
		{			
			logger.debug("Delete one User, the user id: " + user.getUserID());
		}
		
		return effectedRows;
	}

	@Override
	public List<UserModel> getUser(UserModel user, int userId) throws Exception {

		List<UserModel> users = userDAO.getUser(user, userId);
		
		if(logger.isDebugEnabled())
		{			
			if(users == null)
			{
				logger.debug("No one user found, the query user model: " + user.toString());
			}
			else
			{
				logger.debug(users.size() + " users found, the query user model: " + user.toString());
			}		
		}
		
		return users;
	}
	
	@Override
	public UserModel login(UserModel user) throws Exception {

		UserModel result = null;
		List<UserModel> users = getUser(user, 0);
		if(users != null && users.size() == 1)
		{
			result = users.get(0);
		}
		
		return result;
	}
	
	@Override
	public boolean auth(int userID) throws Exception {
		
		boolean auth = false;
		
		UserModel user = new UserModel();
		user.setUserID(userID);
		
		List<UserModel> users = getUser(user, 0);
		if(users.size() == 1)
		{
			auth = users.get(0).getStatus();		
		}
		
		return auth;
	}
	
	@Override
	public boolean logout(UserModel user) throws Exception {
		// To-do
		// 1, 更新User的登陆状态
		return true;
	}
	
	@Override
	public boolean register(UserModel user) throws Exception {
		
		return insertUser(user, 0) > 0 ? true: false;
	}
	

}
