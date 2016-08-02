package com.entity;

//登录账户实体类
public class Admin implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer aid;
	private String aname;
	private String apassword;
	private String choose;

	public Admin() {
		
	}

	public Admin(String aname, String apassword, String choose) {
		this.aname = aname;
		this.apassword = apassword;
		this.choose = choose;
	}


	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApassword() {
		return this.apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public String getChoose() {
		return this.choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", apassword="
				+ apassword + ", choose=" + choose + "]";
	}

}