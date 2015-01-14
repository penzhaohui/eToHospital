package com.etohospital.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etohospital.business.UserBusiness;
import com.etohospital.model.UserModel;
import com.etohospital.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int _acceptedDisclaimer;
	private String _userName;
	private String _password;
	private String _confirmedPassword;
	private int _userType;
	private String _mobilePhone;
	private String _idNo;
	
	public String login() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		UserModel user = new UserModel();
		user.setUserName(_userName);
		user.setPassword(_password);
		
		UserService userService = UserBusiness.getSingleton();
		user = userService.login(user);
		String nextAction = LOGIN;
		if(user != null){
			session.setAttribute(GlobalConstant.LOGINED_USER, user);
			session.setAttribute(GlobalConstant.USER_TYPE, user.getUserType());
			nextAction = SUCCESS;
		} else {
			session.setAttribute(GlobalConstant.LOGINED_USER, null);
			session.setAttribute(GlobalConstant.USER_TYPE, 0);
		}		
			
		return nextAction;
	}
	
	public String disclaimer() throws Exception {
		
		if(_acceptedDisclaimer == 1)
		{
			return SUCCESS;
		}
		
		return LOGIN;
	}
	
	public String register() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
			
		UserModel user = new UserModel();
		user.setUserName(_userName);
		user.setPassword(_password);
		user.setUserType(_userType);
		user.setMobilePhone(_mobilePhone);
		
		UserService userService = UserBusiness.getSingleton();
		boolean success = userService.register(user);
		String nextAction = LOGIN;
		if(success){
			user = userService.login(user);
			request.setAttribute(GlobalConstant.LOGINED_USER, user);
			session.setAttribute(GlobalConstant.LOGINED_USER, user);
			
			switch(_userType){
				case 1: 
					break;
				case 2:
					break;
				case 3:
					break;
			}
		} else {
			request.setAttribute(GlobalConstant.LOGINED_USER, null);
			session.setAttribute(GlobalConstant.LOGINED_USER, null);
		}		
			
		return nextAction;
	}	
	
	public String bound() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String openId = (String)session.getAttribute(GlobalConstant.OPEN_ID);
		UserModel user = (UserModel) session.getAttribute(GlobalConstant.LOGINED_USER);
		
		user.setWeixin(openId);
		UserService userService = UserBusiness.getSingleton();
		int result = userService.updateUser(user, user.getUserID());
		if(result == 1) {
			
		}
		
		return SUCCESS;
	}
	
	public String logout() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		UserModel user = (UserModel) session.getAttribute(GlobalConstant.LOGINED_USER);
		
		if(user != null)
		{
			UserService userService = UserBusiness.getSingleton();
			userService.logout(user);
			request.setAttribute(GlobalConstant.LOGINED_USER, null);
			session.setAttribute(GlobalConstant.LOGINED_USER, null);
		}			
			
		return LOGIN;
	}

	public int getAcceptedDisclaimer() {
		return _acceptedDisclaimer;
	}

	public void setAcceptedDisclaimer(int acceptedDisclaimer) {
		_acceptedDisclaimer = acceptedDisclaimer;
	}
	
	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getConfirmedPassword() {
		return _confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		_confirmedPassword = confirmedPassword;
	}

	public int getUserType() {
		return _userType;
	}

	public void setUserType(int userType) {
		_userType = userType;
	}
	
	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public String getIDNo() {
		return _idNo;
	}

	public void setIDNo(String iDNo) {
		_idNo = iDNo;
	}

	
}
