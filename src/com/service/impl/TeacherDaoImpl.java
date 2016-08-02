package com.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.HibernateSessionFactory;
import com.entity.Teacher;
import com.service.TeacherDao;

public class TeacherDaoImpl implements TeacherDao {

	//查询全部教师信息方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> queryAllTeacher() {
		Transaction tx = null;
		List<Teacher> list = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			String hql = "from Teacher ";
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
	
	//查询一个教师信息方法
	@Override
	public Teacher queryOneTeacher(String t) {
		Transaction tx = null;
		Teacher list = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			list = (Teacher)session.get(Teacher.class,Integer.parseInt(t));
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
	
	//获取教师主键值方法
	public Integer getNewTid(){
		Transaction tx = null;
		Integer tid = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			String hql = "select max(tid) from Teacher";
			Query query = session.createQuery(hql);
			tid = (Integer) query.uniqueResult();
			if(tid==null||"".equals(tid)){
				tid = 1220080001;
			}
			else{
				tid++;
			}
			tx.commit();
			return tid;
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
	
	//添加教师信息方法
	@Override
	public boolean addTeacher(Teacher t) {
		t.setTid(getNewTid());
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(t);;
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

	//修改教师信息方法
	@Override
	public boolean updateTeacher(Teacher t) {
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(t);
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

	//删除教师信息方法
	@Override
	public boolean deleteTeacher(Integer tid) {
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Teacher t = (Teacher)session.get(Teacher.class, tid);
			session.delete(t);
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


