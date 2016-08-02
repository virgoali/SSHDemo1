package com.entity;

public class Teacher implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer tid;
	private String tname;
	private String tpassword;
	private String tsex;
	private String tage;
	private String tdepartment;
	private String tclass;

	public Teacher() {
	}

	public Teacher(Integer tid, String tname, String tpassword, String tsex, String tage, String tdepartment,
			String tclass) {
		this.tid = tid;
		this.tname = tname;
		this.tpassword = tpassword;
		this.tsex = tsex;
		this.tage = tage;
		this.tdepartment = tdepartment;
		this.tclass = tclass;
	}


	public Integer getTid() {
		return this.tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTpassword() {
		return this.tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public String getTsex() {
		return this.tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	public String getTage() {
		return this.tage;
	}

	public void setTage(String tage) {
		this.tage = tage;
	}

	public String getTdepartment() {
		return this.tdepartment;
	}

	public void setTdepartment(String tdepartment) {
		this.tdepartment = tdepartment;
	}

	public String getTclass() {
		return this.tclass;
	}

	public void setTclass(String tclass) {
		this.tclass = tclass;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tpassword=" + tpassword + ", tsex=" + tsex + ", tage="
				+ tage + ", tdepartment=" + tdepartment + ", tclass=" + tclass + "]";
	}
	
}