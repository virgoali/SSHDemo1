package com.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.db.HibernateSessionFactory;
import com.entity.Student;
import com.service.StudentDao;

public class StudentDaoImpl implements StudentDao {
	
	//查询全部学生信息方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> queryAllStudent() {
		Transaction tx = null;
		List<Student> list = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			String hql = "from Student ";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}
	
	//查询一个学生信息方法
	@Override
	public Student queryOneStudent(String s) {
		Transaction tx = null;
		Student list = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			list = (Student)session.get(Student.class,Integer.parseInt(s));
			tx.commit();
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}
	
	//获取学生主键值方法
	public Integer getNewSno(){
		Transaction tx = null;
		Integer sno = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			String hql = "select max(sno) from Student";
			Query query = session.createQuery(hql);
			sno = (Integer) query.uniqueResult();
			if(sno==null||"".equals(sno)){
				sno = 1330090001;
			}
			else{
				sno++;
			}
			tx.commit();
			return sno;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return null;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}
	
	//添加学生信息方法
	@Override
	public boolean addStudent(Student s) {
		s.setSno(getNewSno());
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.rollback();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	//修改学生信息方法
	@Override
	public boolean updateStudent(Student s) {
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	//删除学生信息方法
	@Override
	public boolean deleteStudent(Integer sno) {
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Student s = (Student)session.get(Student.class, sno);
			session.delete(s);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}


	}


