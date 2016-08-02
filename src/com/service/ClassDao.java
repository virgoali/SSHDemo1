package com.service;

import java.util.List;

import com.entity.Class;

public interface ClassDao {
	public List<Class> queryAllClass();
	public Class queryOneClass(String cid);
	public boolean addClass(Class c);
	public boolean updateClass(Class c);
	public boolean deleteClass(Integer cid);
}
