package com.entity;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student{

	// Fields

	private Integer sno;
	private String spassword;
	private String sname;
	private String ssex;
	private String sage;
	private String saddress;
	private String department;
	private Teacher tname;
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSage() {
		return sage;
	}
	public void setSage(String sage) {
		this.sage = sage;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Teacher getTname() {
		return tname;
	}
	public void setTname(Teacher tname) {
		this.tname = tname;
	}


	@Override
	public String toString() {
		return "Student [sno=" + sno + ", spassword=" + spassword + ", sname=" + sname + ", ssex=" + ssex + ", sage="
				+ sage + ", saddress=" + saddress + ", department=" + department + ", tname=" + tname + "]";
	}
	public Student() {
	}
	public Student(Integer sno, String spassword, String sname, String ssex, String sage, String saddress,
			String department, Teacher tname) {
		this.sno = sno;
		this.spassword = spassword;
		this.sname = sname;
		this.ssex = ssex;
		this.sage = sage;
		this.saddress = saddress;
		this.department = department;
	}


}