package com.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.db.HibernateSessionFactory;
import com.entity.Admin;
import com.service.AdminDao;

public class AdminDaoImpl implements AdminDao{
	
	//登录判断方法
	@SuppressWarnings("unchecked")
	@Override
	public boolean adminlogin(Admin a) {
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			String hql = "from Admin where aname=? and apassword=? and choose=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, a.getAname());
			query.setParameter(1, a.getApassword());
			query.setParameter(2, a.getChoose());
			List<Admin> list = query.list();
			tx.commit();
			if(list.size()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
	
	//修改密码方法
	@Override
	public boolean UpdatePassword(Admin a,Admin b){
		Transaction tx = null;
		try
		{
			Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Admin c = (Admin) session.get(Admin.class, 1);
			
			if(b.getApassword().toString().equals(c.getApassword().toString())){
			c.setApassword(a.getApassword().toString());
			session.update(c);
			tx.commit();
			return true;
			}
			else{
				tx.commit();
				return false;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
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
