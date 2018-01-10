package com.loski.collect.share.common.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PermissionInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690951105223316978L;

	private String interceptorType;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {

		final HttpServletRequest request = ServletActionContext.getRequest();
        final String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + "/";
        request.setAttribute("basePath", basePath);

		return "login";
	}
	
	

	public String getInterceptorType() {
		return interceptorType;
	}

	public void setInterceptorType(String interceptorType) {
		this.interceptorType = interceptorType;
	}

}
