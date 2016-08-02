package com.service.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.HibernateSessionFactory;
import com.entity.Class;
import com.service.ClassDao;

public class ClassDaoImpl implements ClassDao {

	//查询全部班级信息方法
	@SuppressWarnings("unchecked")
	@Override
	public List<Class> queryAllClass() {
		Transaction tx = null;
		List<Class> list = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			String hql = "from Class ";
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
	
	//查询一个班级信息方法
	@Override
	public Class queryOneClass(String c) {
		Transaction tx = null;
		Class list = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			list = (Class)session.get(Class.class,Integer.parseInt(c));
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
	
	//获取班级主键值方法
	public Integer getNewCid(){
		Transaction tx = null;
		Integer cid = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			String hql = "select max(cid) from Class";
			Query query = session.createQuery(hql);
			cid = (Integer) query.uniqueResult();
			if(cid==null||"".equals(cid)){
				cid = 10010;
			}
			else{
				cid++;
			}
			tx.commit();
			return cid;
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
	
	//添加班级信息方法
	@Override
	public boolean addClass(Class c) {
		c.setCid(getNewCid());
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(c);;
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

	//修改班级信息方法
	@Override
	public boolean updateClass(Class c) {
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(c);
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

	//删除班级信息方法
	@Override
	public boolean deleteClass(Integer cid) {
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Class c = (Class)session.get(Class.class, cid);
			session.delete(c);
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


