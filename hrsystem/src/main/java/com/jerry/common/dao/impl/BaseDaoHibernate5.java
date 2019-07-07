package com.jerry.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.jerry.common.dao.BaseDao;

public class BaseDaoHibernate5<T> implements BaseDao<T>
{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public T get(Class<T> entityClazz, Serializable id)
	{
		return (T)sessionFactory.getCurrentSession().get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity)
	{
		return sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity)
	{
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id)
	{
		delete(get(entityClazz, id));
	}

	@Override
	public List<T> findAll(Class<T> entityClazz)
	{
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	@Override
	public long findCound(Class<T> entityClazz)
	{
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		
		if (l != null && l.size() ==1)
		{
			return (long)l.get(0);
		}
		
		return 0;
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String hql)
	{
		return (List<T>)sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<T> find(String hql, Object... params)
	{
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		for (int i = 0; i < params.length; i++)
		{
			query.setParameter(i, params[i]);
		}
		
		return (List<T> )query.list();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize)
	{
		return sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params)
	{
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++)
		{
			query.setParameter(i, params[i]);
		}
		
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}
}
