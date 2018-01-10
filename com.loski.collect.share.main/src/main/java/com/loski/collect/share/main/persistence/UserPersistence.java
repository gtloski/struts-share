package com.loski.collect.share.main.persistence;

import java.util.Map;

import com.loski.collect.share.main.entity.UserData;

import tk.mybatis.mapper.common.Mapper;

public interface UserPersistence extends Mapper<UserData>{

	UserData byPassAndAcc(UserData user);
	
	void batchAdd(Map<String, Object> map);

	void inserUser(UserData data);
}
