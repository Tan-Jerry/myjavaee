package com.jerry.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.jerry.domain.User;
import com.jerry.domain.User_;

public class DaoUserJpa
{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("sqlserver_sap");
	
	public void addUsers()
	{
		EntityManager eManager = emf.createEntityManager();
		
		EntityTransaction eTransaction = eManager.getTransaction();
		eTransaction.begin();
		
		for (int i = 0; i < 100000; i++)
		{
			User user = new User();
			
			user.setUsername("xxxxxx" + i);
			user.setPassword(new Integer(i).toString());
			
			eManager.persist(user);
			
			if (i % 20 == 0)
			{
				eManager.flush();
				eManager.clear();
			}
		}
		
		eTransaction.commit();
		eManager.close();
		emf.close();
	}
	
	public void queryUsers()
	{
		EntityManager eManager = emf.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		
		transaction.begin();
		
		CriteriaBuilder builder = eManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		
		Root<User> root = criteriaQuery.from(User.class);
		
		criteriaQuery.select(root);
		
		Predicate predicate = builder.lessThan(root.get(User_.id), 50);
		
		criteriaQuery.where(predicate);
		
		List<User> users = eManager.createQuery(criteriaQuery).getResultList();
		
		System.out.println("simple criteria query to get user info");
		
		for (User user: users)
		{
			System.out.println(user.getUsername() + " : " + user.getPassword());
		}
		
		transaction.commit();
		
		eManager.close();
		emf.close();
	}
}
