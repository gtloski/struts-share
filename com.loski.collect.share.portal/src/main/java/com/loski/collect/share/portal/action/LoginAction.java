package com.loski.collect.share.portal.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.loski.collect.share.common.action.StrutsAction;
import com.loski.collect.share.main.entity.UserData;
import com.loski.collect.share.shiro.util.ShiroUtils;

import net.sf.json.JSONObject;

@Namespace("/")
@ParentPackage("loski-default")
public class LoginAction extends StrutsAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5097189799987436067L;
	
	private String account;
	
	private String password;
	
	private UserData user;

	@Action(value="login",results={@Result(name="success",type="freemarker",location="/ui/html/login.html")})
	public String login(){
		
		return SUCCESS;
	}
	
	@Action(value="json", results = { @Result(name = "success", type="json") })
	public String json(){
		
		try {
			final Map<String, Object> rs = new HashMap<String, Object>();
			rs.put("success", false);
			this.setResultJson(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value="doLogin", results = { @Result(name = "success", type="json") })
	public String doLogin(){
		
		try{
			Subject subject = ShiroUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(account, password);
			subject.login(token);
		}catch (UnknownAccountException e) {
			Map<String, Object> rs = new HashMap<String, Object>();
			rs.put("success", false);
			rs.put("msg", "未知账号");
			this.setResultJson(rs);
			return SUCCESS;
		}catch (IncorrectCredentialsException e) {
			Map<String, Object> rs = new HashMap<String, Object>();
			rs.put("success", false);
			rs.put("msg", "密码错误");
			this.setResultJson(rs);
			return SUCCESS;
		}catch (LockedAccountException e) {
			Map<String, Object> rs = new HashMap<String, Object>();
			rs.put("success", false);
			rs.put("msg", "账户被锁，请联系管理员！");
			this.setResultJson(rs);
			return SUCCESS;
		}catch (AuthenticationException e) {
			Map<String, Object> rs = new HashMap<String, Object>();
			rs.put("success", false);
			rs.put("msg", "认证失败");
			this.setResultJson(rs);
			return SUCCESS;
		}
//		final JSONObject userJson = new JSONObject();
//		userJson.put("userId", account);
//		final HttpSession session = request.getSession();
//		session.setAttribute("user", userJson);
		
		Map<String, Object> rs = new HashMap<String, Object>();
		rs.put("success", true);
		rs.put("msg", "登录成功");
		this.setResultJson(rs);
		return SUCCESS;
	}

	/**************getter or setter****************/
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}
}
