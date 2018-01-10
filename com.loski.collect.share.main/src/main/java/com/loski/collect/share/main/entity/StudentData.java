package com.loski.collect.share.main.entity;

import javax.persistence.Transient;

public class StudentData extends BaseEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6419158719387066052L;

	private String name;
	
	private String teacherId;
	
	@Transient
	private TeacherData teacher;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public TeacherData getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherData teacher) {
		this.teacher = teacher;
	}

}
