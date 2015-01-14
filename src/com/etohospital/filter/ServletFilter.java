package com.etohospital.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ServletFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;

		// http://blog.csdn.net/huilangeliuxin/article/details/10495403
		String target = request.getRequestURI();
		int index = target.indexOf("/servlet/");
		if(index > 0)
		{
			target = target.substring(index + "/servlet/".length() - 1);
			
			// request.getRequestURI()格式应该形如：/servlet/v1/oauth2，
			// 其中st是项目名，servlet是所有servlet都增加的前缀，用于能够判断出是servlet。
			// if只判断请求uri是否包含/servlet/，如果包含则处理；
			RequestDispatcher rdsp = request.getRequestDispatcher(target);
			rdsp.forward(req, resp);
		} else {
			chain.doFilter(req, resp);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
