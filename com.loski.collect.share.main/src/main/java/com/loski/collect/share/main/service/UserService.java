package com.loski.collect.share.main.service;

import java.util.List;

import com.loski.collect.share.main.entity.UserData;

public interface UserService {
	
	void insertUser(UserData user);
	
	List<UserData> userList();
	
	UserData selectById(String str);
	
	List<UserData> selectByAccount();
	
	UserData byPassAndAcc();
	
	List<UserData> batchAddUser(List<UserData> userList);
	
	UserData insertUsers(UserData data);
}
