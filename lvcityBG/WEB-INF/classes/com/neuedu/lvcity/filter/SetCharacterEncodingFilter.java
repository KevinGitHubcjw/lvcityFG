package com.neuedu.lvcity.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SetCharacterEncodingFilter implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/**
	 * Select and set (if specified) the character encoding to be used to
	 * interpret request parameters for this request.
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");

		// 浼犻?掓帶鍒跺埌涓嬩竴涓繃婊ゅ櫒
		chain.doFilter(request, response);
	}

	public void destroy() {
	}
}
