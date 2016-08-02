package com.action;

import java.util.List;









import com.entity.Class;
import com.service.ClassDao;
import com.service.impl.ClassDaoImpl;

public class ClassAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	
	//查询全部班级信息
	public String query(){
		ClassDao cdao = new ClassDaoImpl();
		List<Class> list = cdao.queryAllClass();
		if(list!=null&&list.size()>0){
			session.setAttribute("class_list", list);
		}
		else{
		    session.setAttribute("class_list",null);
		}
		return "query_success";
	}
	
	//查询一个班级信息
	public String queryone(){
		String cid =request.getParameter("cid");
		ClassDao cdao = new ClassDaoImpl();
		Class list = cdao.queryOneClass(cid);
		session.setAttribute("class_listone", list);
		return "queryone_success";
	}
	
	//删除班级信息
	public String delete(){
		ClassDao cdao = new ClassDaoImpl();
		String cid = request.getParameter("cid");
		cdao.deleteClass(Integer.parseInt(cid));
		return "delete_success";
	}
	
	//添加班级信息
	public String add() {
		ClassDao cdao = new ClassDaoImpl();
		Class c = new Class();
		c.setCname(request.getParameter("cname"));
		c.setCteacher(request.getParameter("cteacher"));
		c.setCtime(request.getParameter("ctime"));
		cdao.addClass(c);
		return "add_success";
	}
	
	//修改班级信息
	public String update() {
		ClassDao cdao = new ClassDaoImpl();
		Class c = new Class();
		c.setCid(Integer.parseInt(request.getParameter("cid")));
		c.setCname(request.getParameter("cname"));
		c.setCteacher(request.getParameter("cteacher"));
		c.setCtime(request.getParameter("ctime"));
		cdao.updateClass(c);
		return "update_success";
	}
}
