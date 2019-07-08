package com.jerry.hrsystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jerry.common.dao.impl.BaseDaoHibernate5;
import com.jerry.hrsystem.dao.ManagerDao;
import com.jerry.hrsystem.domain.Manager;

@Component
public class ManagerDaoHibernate5 extends BaseDaoHibernate5<Manager> implements ManagerDao
{
	@Override
	public List<Manager> findByNameAndPass(Manager mgr)
	{
		return find("select m from Manager m where m.name = ?0 and m.pass = ?1", mgr.getName(), mgr.getPass());
	}
	
	@Override
	public Manager findByName(String name)
	{
		List<Manager> ml = find("select m from Manager m where m.name = ?0", name);
		
		if (ml != null && ml.size() > 0)
		{
			return ml.get(0);
		}
		
		return null;
	}
}
