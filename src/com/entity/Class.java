package com.entity;

/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class Class implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String cname;
	private String cteacher;
	private String ctime;

	// Constructors

	/** default constructor */
	public Class() {
	}

	/** minimal constructor */
	public Class(Integer cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Class(Integer cid, String cname, String cteacher, String ctime) {
		this.cid = cid;
		this.cname = cname;
		this.cteacher = cteacher;
		this.ctime = ctime;
	}

	// Property accessors

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