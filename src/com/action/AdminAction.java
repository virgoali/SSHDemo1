package com.action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.entity.Admin;
import com.opensymphony.xwork2.ModelDriven;
import com.service.AdminDao;
import com.service.impl.AdminDaoImpl;

public class AdminAction extends SuperAction implements ModelDriven<Admin>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Admin admin = new Admin();
	public String login()
	{
		AdminDao adao = new AdminDaoImpl();
		if(adao.adminlogin(admin))
		{
			session.setAttribute("AdminLoginName",admin.getAname());
			return "login_success";
		}
		else
		{
			this.addFieldError("AdminPasswordError", "请输入正确的密码！！！");
			return "login_failure";
		}
	}

	@SkipValidation
	public String LoginOut(){
		if(session.getAttribute("AdminLoginName")!=null){
			session.removeAttribute("AdminLoginName");
		}
		return "login_out";
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if("".equals(admin.getAname().trim())){
			this.addFieldError("AdminNameError", "请输入正确的用户名和密码！！！");
		}
	}
	public String updatepassword(){
		AdminDao adao = new AdminDaoImpl();
		Admin a = new Admin();
		Admin b = new Admin();
		String p1 = request.getParameter("newpasswordone");
		String p2 = request.getParameter("newpasswordtwo");
		a.setApassword(request.getParameter("newpasswordone"));
		b.setApassword(request.getParameter("oldpassword"));
		if(p1.equals(p2)){
			if(adao.UpdatePassword(a,b)){
			return "updatepassword_success";
			}
			else{
				this.addFieldError("OldPasswordError", "请输入正确的密码！！！");
				return "updatepassword_failure";
			}
		}
		else{
			this.addFieldError("NewPasswordError", "两次输入密码不一致！！！");
			return "updatepassword_failure";
		}
	}
	public Admin getModel() {
		// TODO Auto-generated method stub
		return this.admin;
	}

}
