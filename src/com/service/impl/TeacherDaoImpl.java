package com.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.HibernateSessionFactory;
import com.entity.Teacher;
import com.service.TeacherDao;

public class TeacherDaoImpl implements TeacherDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> queryAllTeacher() {
		// TODO Auto-generated method stub
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
	@Override
	public Teacher queryOneTeacher(String t) {
		// TODO Auto-generated method stub
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
	@Override
	public boolean addTeacher(Teacher t) {
		// TODO Auto-generated method stub
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

	@Override
	public boolean updateTeacher(Teacher t) {
		// TODO Auto-generated method stub
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
//			tx.rollback();
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

	@Override
	public boolean deleteTeacher(Integer tid) {
		// TODO Auto-generated method stub
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


