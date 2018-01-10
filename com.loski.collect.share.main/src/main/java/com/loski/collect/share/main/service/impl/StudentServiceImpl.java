package com.loski.collect.share.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loski.collect.share.main.entity.StudentData;
import com.loski.collect.share.main.persistence.StudentPersistence;
import com.loski.collect.share.main.service.StudentService;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentPersistence studentPersistence;
	
	public StudentData selectById(String id) {
		
		return studentPersistence.selectById(id);
	}

	public List<StudentData> select() {
		// TODO Auto-generated method stub
		return studentPersistence.selectAll();
	}
	
}
