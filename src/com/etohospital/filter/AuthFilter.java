package com.etohospital.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etohospital.action.GlobalConstant;
import com.etohospital.model.UserModel;

// Struts2过滤用户非法登陆 : 
// http://blog.csdn.net/class_horse/article/details/17456927
public class AuthFilter extends HttpServlet implements Filter {

	private static final long serialVersionUID = 1763873603758152076L;

	@Override
	public void destroy() {		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;  
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();  
		String url = request.getRequestURI();

		UserModel user = (UserModel) session.getAttribute(GlobalConstant.LOGINED_USER);
		if(user == null) {
			
			if (url.indexOf("login.jsp") > 0
					|| url.indexOf("disclaimer.jsp") > 0 
					|| url.indexOf("register.jsp") > 0
					|| url.indexOf("register_success.jsp") > 0){
				
				filterChain.doFilter(req, resp);  
			}
			else {
				response.sendRedirect(contextPath + "/mobile/login.jsp");
			}
			
		} else {
			
			int userType = 0;
			if(url.indexOf("customer") > 0) {
				userType = 1;
			} else if(url.indexOf("healthconsultant") > 0) {
				userType = 2;
			} else if(url.indexOf("doctor") > 0) {
				userType = 3;
			}
			
			// 非法访问界面，强制用户退出
			if(userType != user.getUserType()) {
				session.setAttribute(GlobalConstant.LOGINED_USER, null);				
				response.sendRedirect(contextPath + "/mobile/login.jsp");  
			}
						
			filterChain.doFilter(req, resp);  			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
