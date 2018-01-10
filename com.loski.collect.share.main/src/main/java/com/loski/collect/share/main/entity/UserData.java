package com.loski.collect.share.main.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class UserData implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7106293736314684847L;
	
	private String id;
	
	private String account;
	
	private String password;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

}
