package com.action;

import java.util.List;
import com.entity.Student;
import com.service.StudentDao;
import com.service.impl.StudentDaoImpl;

public class StudentAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//查询全部学生
	public String query(){
		StudentDao sdao = new StudentDaoImpl();
		List<Student> list = sdao.queryAllStudent();
		if(list!=null&&list.size()>0){
			session.setAttribute("student_list", list);
		}
		else{
		    session.setAttribute("student_list",null);
		}
		return "query_success";
	}
	//查询单个学生
	public String queryone(){
		String sno =request.getParameter("sno");
		StudentDao sdao = new StudentDaoImpl();
		Student list = sdao.queryOneStudent(sno);
		session.setAttribute("student_listone", list);
		return "queryone_success";
	}
	//删除学生
	public String delete(){
		StudentDao sdao = new StudentDaoImpl();
		String sno = request.getParameter("sno");
		sdao.deleteStudent(Integer.parseInt(sno));
		return "delete_success";
	}
	//添加学生
	public String add() {
		StudentDao sdao = new StudentDaoImpl();
		Student s = new Student();
		s.setSpassword(request.getParameter("spassword"));
		s.setSname(request.getParameter("sname"));
		s.setSsex(request.getParameter("ssex"));
		s.setSage(request.getParameter("sage"));
		s.setSaddress(request.getParameter("saddress"));
		s.setDepartment(request.getParameter("department"));
		sdao.addStudent(s);
		return "add_success";
	}
	//修改学生
	public String update() {
		StudentDao sdao = new StudentDaoImpl();
		Student s = new Student();
		s.setSno(Integer.parseInt(request.getParameter("sno")));
		s.setSpassword(request.getParameter("spassword"));
		s.setSname(request.getParameter("sname"));
		s.setSsex(request.getParameter("ssex"));
		s.setSage(request.getParameter("sage"));
		s.setSaddress(request.getParameter("saddress"));
		s.setDepartment(request.getParameter("department"));
		sdao.updateStudent(s);
		return "update_success";
	}
}
