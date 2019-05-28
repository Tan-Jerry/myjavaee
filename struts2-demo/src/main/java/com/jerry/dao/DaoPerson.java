package com.jerry.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jerry.domain.Person;

public class DaoPerson
{
	public void addPerson(Person person)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(person);
		
		transaction.commit();
		
		session.close();
		sessionFactory.close();
	}
}
