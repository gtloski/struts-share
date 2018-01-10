package com.loski.collect.share.common.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class StrutsAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware, Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6064762944755187848L;
	
	private transient Object object = new Object();
	
	/**
	 * 内置的request对象，由容器注入。
	 */
	protected HttpServletRequest request;

	/**
	 * 内置的response对象，由容器注入。
	 */
	protected HttpServletResponse response;

	/**
	 * 内置的session对象，由容器注入。
	 */
	protected Map<String, Object> sessionMap;
	
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}

	public Object getResultJson() {
		return object;
	}

	public void setResultJson(Object object) {
		this.object = object;
	}
}
