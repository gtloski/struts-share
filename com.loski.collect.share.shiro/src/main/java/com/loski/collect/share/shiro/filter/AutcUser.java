package com.loski.collect.share.shiro.filter;

public class AutcUser {

	public static final String DEFAULT_PASSWORD = "123456";

	
	/**
	 * id
	 */
	private String id;
	
	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;
	
	public AutcUser(String id, String name, String password){
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
