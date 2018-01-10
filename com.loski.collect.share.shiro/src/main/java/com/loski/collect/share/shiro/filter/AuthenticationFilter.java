package com.loski.collect.share.shiro.filter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.loski.collect.share.shiro.entity.AuthenticationToken;

public class AuthenticationFilter extends FormAuthenticationFilter {

	private static final String DEFAULT_EN_PASSWORD_PARAM = "enPassword";

	private static final String DEFAULT_CAPTCHA_ID_PARAM = "captchaId";

	private static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	private String enPasswordParam = DEFAULT_EN_PASSWORD_PARAM;

	private String captchaIdParam = DEFAULT_CAPTCHA_ID_PARAM;

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;

	

	/**
	 * 创建 Token
	 */
	@Override
	protected org.apache.shiro.authc.AuthenticationToken createToken(
			ServletRequest servletRequest, ServletResponse servletResponse) {
		System.out.println("AuthenticationFilter.createToken()");
		String username = getUsername(servletRequest);
		String password = getPassword(servletRequest);
		String captchaId = getCaptchaId(servletRequest);
		String captcha = getCaptcha(servletRequest);
		boolean rememberMe = isRememberMe(servletRequest);
		String host = getHost(servletRequest);
		return new AuthenticationToken(username, password, captchaId, captcha,
				rememberMe, host);
	}

	/**
	 * 访问拒接时候的处理
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest servletRequest,
			ServletResponse servletResponse) throws Exception {
		System.out.println("AuthenticationFilter.onAccessDenied()");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String requestType = request.getParameter("type");//判断ajax请求
		if (StringUtils.equals(requestType, "ajax")&&StringUtils.equals(request.getMethod().toLowerCase(), "post")) {
			response.setCharacterEncoding("UTF-8");//处理中文乱码
			response.setContentType("text/html;charset=UTF-8");//处理中文乱码
			response.getWriter().println("{result:false,msg:'登录失败'}");
			return false;
		}
		return super.onAccessDenied(request, response);
	}

	/**
	 * 登录成功以后
	 */
	@Override
	protected boolean onLoginSuccess(
			org.apache.shiro.authc.AuthenticationToken token, Subject subject,
			ServletRequest servletRequest, ServletResponse servletResponse)
			throws Exception {
		Session session = subject.getSession();
		Map<Object, Object> attributes = new HashMap<Object, Object>();//保存属性
		Collection<Object> keys = session.getAttributeKeys();//获取key信息
		for (Object key : keys) {
			attributes.put(key, session.getAttribute(key));//获取属性
		}
		session.stop();//销毁会话
		session = subject.getSession();//新建会话
		for (Entry<Object, Object> entry : attributes.entrySet()) {
			session.setAttribute(entry.getKey(), entry.getValue());//设置属性
		}
		//ajax方式
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String requestType = request.getParameter("type");//判断ajax请求
		if (StringUtils.equals(requestType, "ajax")) {
			AutcUser autcUser=(AutcUser)subject.getPrincipal();
			response.setCharacterEncoding("UTF-8");//处理中文乱码
			response.setContentType("text/html;charset=UTF-8");//处理中文乱码
//			String msg=String.format("{result:true,msg:'登录成功',content:{id:'%s',username:'%s',name:'%s'}}",autcUser.getId(),autcUser.getUsername(),autcUser.getName());
//			response.getWriter().println(msg);
			return false;
		}
		return super.onLoginSuccess(token, subject, servletRequest,
				servletResponse);
	}

	@Override
	protected String getPassword(ServletRequest servletRequest) {
		String password = WebUtils.getCleanParam(servletRequest,
				"password");
		return DigestUtils.md5Hex(password) ;
	}

	protected String getCaptchaId(ServletRequest servletRequest) {
		String captchaId = WebUtils.getCleanParam(servletRequest,
				captchaIdParam);
		if (captchaId == null) {
			captchaId = ((HttpServletRequest) servletRequest).getSession()
					.getId();
		}
		return captchaId;
	}

	protected String getCaptcha(ServletRequest servletRequest) {
		return WebUtils.getCleanParam(servletRequest, captchaParam);
	}

	public String getEnPasswordParam() {
		return enPasswordParam;
	}

	public void setEnPasswordParam(String enPasswordParam) {
		this.enPasswordParam = enPasswordParam;
	}

	public String getCaptchaIdParam() {
		return captchaIdParam;
	}

	public void setCaptchaIdParam(String captchaIdParam) {
		this.captchaIdParam = captchaIdParam;
	}

	public String getCaptchaParam() {
		return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}
}
