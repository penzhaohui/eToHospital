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
			
			// request.getRequestURI()��ʽӦ�����磺/servlet/v1/oauth2��
			// ����st����Ŀ����servlet������servlet�����ӵ�ǰ׺�������ܹ��жϳ���servlet��
			// ifֻ�ж�����uri�Ƿ����/servlet/�������������
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
