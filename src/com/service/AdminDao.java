package com.service;

import com.entity.Admin;

public interface AdminDao {
	public boolean adminlogin(Admin a);
	public boolean UpdatePassword(Admin a, Admin b);
}
