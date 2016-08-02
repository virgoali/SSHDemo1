package com.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.HibernateSessionFactory;
import com.entity.Teacher;
import com.service.TeacherDao;

public class TeacherDaoImpl implements TeacherDao {

	//��ѯȫ����ʦ��Ϣ����
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
	
	//��ѯһ����ʦ��Ϣ����
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
	
	//��ȡ��ʦ����ֵ����
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
	
	//��ӽ�ʦ��Ϣ����
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

	//�޸Ľ�ʦ��Ϣ����
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

	//ɾ����ʦ��Ϣ����
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


