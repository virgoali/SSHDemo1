package com.service;

import java.util.List;

import com.entity.Teacher;

public interface TeacherDao {
	public List<Teacher> queryAllTeacher();
	public Teacher queryOneTeacher(String tid);
	public boolean addTeacher(Teacher t);
	public boolean updateTeacher(Teacher t);
	public boolean deleteTeacher(Integer tid);
}
