package com.henu.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class CharacterEncoding
 */
@WebFilter(
		urlPatterns = { 
				"/CharacterEncoding", 
				"/*"
		}, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})
public class CharacterEncoding implements Filter {
	protected static String encoding;

    /**
     * Default constructor. 
     */
    public CharacterEncoding() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		if(encoding!=null)
		{
			request.setCharacterEncoding(encoding);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding=fConfig.getInitParameter("encoding");
	}

}