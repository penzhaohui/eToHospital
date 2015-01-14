package com.etohospital.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etohospital.action.GlobalConstant;
import com.etohospital.wechat.WechatConstant;
import com.etohospital.wechat.WechatUserInfo;
import com.etohospital.wechat.AccessToken;
import com.etohospital.wechat.adapter.IOAuthAdapter;
import com.etohospital.wechat.adapter.imp.OAuthAdapter;
import com.etohospital.wechat.utils.WechatUtil;

@WebServlet("/v1/oauth2")
public class OAuth2Servlet extends HttpServlet {
	
	private static IOAuthAdapter OAuthAdapter = new OAuthAdapter();
	
	public OAuth2Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取来自微信服务器的2个验证参数
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		try {
			AccessToken accessToken = OAuthAdapter.getAuthAccessToken(code);
			accessToken = OAuthAdapter.refreshAuthToken(accessToken.getRefreshToken());
			WechatUserInfo userInfo = OAuthAdapter.getUserInfoByOAuth(accessToken.getAccessToken(), accessToken.getOpenId(), "zn_CH");
			
			//Obtain the session object, create a new session if doesn't exist
			HttpSession session = request.getSession(true);
			session.setAttribute(GlobalConstant.OPEN_ID, accessToken.getOpenId());
			session.setAttribute(GlobalConstant.OAUTH_REFRESH_TOKEN, accessToken.getRefreshToken());
			session.setAttribute(GlobalConstant.OAUTH_ACCESS_TOKEN, accessToken.getAccessToken());
			
			if("customer".equalsIgnoreCase(state))
			{				
				session.setAttribute(GlobalConstant.USER_TYPE, 1);
				response.sendRedirect(WechatUtil.getFullURL(WechatConstant.MOBILE_ROOT_URL, "customer/customer_home.jsp"));
			}
			else if ("healthconsultant".equalsIgnoreCase(state))
			{
				session.setAttribute(GlobalConstant.USER_TYPE, 2);
				response.sendRedirect(WechatUtil.getFullURL(WechatConstant.MOBILE_ROOT_URL, "healthconsultant/healthconsultant_home.jsp"));
			}
			else if ("doctor".equalsIgnoreCase(state))
			{
				session.setAttribute(GlobalConstant.USER_TYPE, 3);
				response.sendRedirect(WechatUtil.getFullURL(WechatConstant.MOBILE_ROOT_URL, "doctor/doctor_home.jsp"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// 解决中文乱码问题：http://blog.csdn.net/xiazdong/article/details/7217022
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
				
		PrintWriter pw = response.getWriter();
		pw.print("暂时不支持");
	}
}
