package com.entity;

//班级实体类
public class Class implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String cname;
	private String cteacher;
	private String ctime;

	public Class() {
		
	}

	public Class(Integer cid) {
		this.cid = cid;
	}

	public Class(Integer cid, String cname, String cteacher, String ctime) {
		this.cid = cid;
		this.cname = cname;
		this.cteacher = cteacher;
		this.ctime = ctime;
	}

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCteacher() {
		return this.cteacher;
	}

	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}

	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	@Override
	public String toString() {
		return "Class [cid=" + cid + ", cname=" + cname + ", cteacher="
				+ cteacher + ", ctime=" + ctime + "]";
	}

}