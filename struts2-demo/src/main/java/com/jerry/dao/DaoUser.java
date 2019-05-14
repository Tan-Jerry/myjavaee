package com.jerry.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jerry.domain.User;

public class DaoUser
{
	public List<User> getUsers()
	{
		List<User> result = new ArrayList<User>();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from User");
		
		result = query.list();
		
		session.close();
		sessionFactory.close();
		
		return result;
	}
	
	public User getUser(String username)
	{
		List<User> userList = getUsers();

		for (User user: userList)
		{
			if (user.getUsername().equals(username))
			{
				return user;
			}
		}
		
		return null;
	}
	
	public User getUser(int id)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		User userEntity = session.get(User.class, id);
		
		session.close();
		sessionFactory.close();
		
		return userEntity;
	}
	
	public void addUser(User user)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		
		transaction.commit();
		
		session.close();
		sessionFactory.close();
	}
	
	public void deleteUser(int id)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		User userEntity = session.get(User.class, id);
		session.delete(userEntity);
		
		transaction.commit();
		
		session.close();
		sessionFactory.close();
	}
	
	public void updateUser(User user)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.update(user);
		
		transaction.commit();
		
		session.close();
		sessionFactory.close();
	}
}
