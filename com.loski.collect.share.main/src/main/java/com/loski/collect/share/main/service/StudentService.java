package com.loski.collect.share.main.service;

import java.util.List;

import com.loski.collect.share.main.entity.StudentData;

public interface StudentService {

	StudentData selectById(String id);
	
	List<StudentData> select();
}
