package com.loski.collect.share.main.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loski.collect.share.main.entity.UserData;
import com.loski.collect.share.main.persistence.UserPersistence;
import com.loski.collect.share.main.service.UserService;

import tk.mybatis.mapper.entity.Example;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserPersistence userPersistence;
	
	public void insertUser(UserData user) {
		
		userPersistence.insert(user);
	}

	public List<UserData> userList() {
		
		return userPersistence.select(null);
	}

	public UserData selectById(String str) {

		return userPersistence.selectByPrimaryKey(str);
	}

	public List<UserData> selectByAccount() {
		
		Example example = new Example(UserData.class);
		example.createCriteria().andEqualTo("account", "fasfsss");
		return userPersistence.selectByExample(example);
		
	}

	public UserData byPassAndAcc() {
		
		UserData user = new UserData();
//		user.setAccount("liguitian");
//		user.setPassword("qwer");
		
		return userPersistence.byPassAndAcc(user);
	}

	@SuppressWarnings("unchecked")
	public List<UserData> batchAddUser(List<UserData> userList) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userList", userList);
		userPersistence.batchAdd(map);
		List<UserData> list = (List<UserData>) map.get("userList");
		for(UserData udata : list){
			System.out.println(udata.getId());
		}
		return null;
	}

	public UserData insertUsers(UserData data) {

		userPersistence.inserUser(data);
		return null;
	}

}
