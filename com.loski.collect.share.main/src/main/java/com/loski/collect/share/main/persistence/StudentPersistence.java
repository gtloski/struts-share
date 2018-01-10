package com.loski.collect.share.main.persistence;

import java.util.List;

import com.loski.collect.share.main.entity.StudentData;

import tk.mybatis.mapper.common.Mapper;

public interface StudentPersistence extends Mapper<StudentData> {

	StudentData selectById(String id);

	List<StudentData> selectAll();
}
