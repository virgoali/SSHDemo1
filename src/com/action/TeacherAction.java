package com.action;

import java.util.List;
import com.entity.Teacher;
import com.service.TeacherDao;
import com.service.impl.TeacherDaoImpl;

public class TeacherAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	
	//��ѯȫ����ʦ��Ϣ
	public String query(){
		TeacherDao tdao = new TeacherDaoImpl();
		List<Teacher> list = tdao.queryAllTeacher();
		if(list!=null&&list.size()>0){
			session.setAttribute("teacher_list", list);
		}
		else{
		    session.setAttribute("teacher_list",null);
		}
		return "query_success";
	}
	
	//��ѯһ����ʦ��Ϣ
	public String queryone(){
		String tid =request.getParameter("tid");
		TeacherDao tdao = new TeacherDaoImpl();
		Teacher list = tdao.queryOneTeacher(tid);
		session.setAttribute("teacher_listone", list);
		return "queryone_success";
	}
	
	//ɾ����ʦ��Ϣ
	public String delete(){
		TeacherDao tdao = new TeacherDaoImpl();
		String tid = request.getParameter("tid");
		tdao.deleteTeacher(Integer.parseInt(tid));
		return "delete_success";
	}
	
	//��ӽ�ʦ��Ϣ
	public String add() {
		TeacherDao sdao = new TeacherDaoImpl();
		Teacher t = new Teacher();
		t.setTname(request.getParameter("tname"));
		t.setTpassword(request.getParameter("tpassword"));
		t.setTsex(request.getParameter("tsex"));
		t.setTage(request.getParameter("tage"));
		t.setTdepartment(request.getParameter("tdepartment"));
		t.setTclass(request.getParameter("tclass"));
		sdao.addTeacher(t);
		return "add_success";
	}
	
	//�޸Ľ�ʦ��Ϣ
	public String update() {
		TeacherDao sdao = new TeacherDaoImpl();
		Teacher t = new Teacher();
		t.setTid(Integer.parseInt(request.getParameter("tid")));
		t.setTname(request.getParameter("tname"));
		t.setTpassword(request.getParameter("tpassword"));
		t.setTsex(request.getParameter("tsex"));
		t.setTage(request.getParameter("tage"));
		t.setTdepartment(request.getParameter("tdepartment"));
		t.setTclass(request.getParameter("tclass"));
		sdao.updateTeacher(t);
		return "update_success";
	}
}
