package com.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.db.HibernateSessionFactory;
import com.entity.Student;
import com.service.StudentDao;

public class StudentDaoImpl implements StudentDao {
	
	//��ѯȫ��ѧ����Ϣ����
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
	
	//��ѯһ��ѧ����Ϣ����
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
	
	//��ȡѧ������ֵ����
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
	
	//���ѧ����Ϣ����
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

	//�޸�ѧ����Ϣ����
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

	//ɾ��ѧ����Ϣ����
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


