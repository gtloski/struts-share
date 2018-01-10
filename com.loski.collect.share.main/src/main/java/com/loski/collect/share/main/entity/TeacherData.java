package com.loski.collect.share.main.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class TeacherData implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5327191645440649895L;
	
	private String id;
	
	private String name;
	
	private String account;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	private String password;
	
	@Transient
	private List<StudentData> tList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<StudentData> gettList() {
		return tList;
	}

	public void settList(List<StudentData> tList) {
		this.tList = tList;
	}

}
