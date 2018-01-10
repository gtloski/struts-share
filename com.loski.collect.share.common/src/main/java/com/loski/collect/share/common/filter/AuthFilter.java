package com.loski.collect.share.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 */
public class AuthFilter extends ActionSupport implements Filter
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 544322619019107039L;

	public void destroy() {
		
		System.out.println("destroy filter...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		System.out.println("进入过滤器");
		chain.doFilter(httpServletRequest, httpServletResponse);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
		System.out.println("init filter...");
	}

	
	
}
