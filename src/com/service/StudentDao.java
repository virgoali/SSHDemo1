package com.service;

import java.util.List;

import com.entity.Student;

public interface StudentDao {
	public List<Student> queryAllStudent();
	public Student queryOneStudent(String sno);
	public boolean addStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Integer sno);
}
