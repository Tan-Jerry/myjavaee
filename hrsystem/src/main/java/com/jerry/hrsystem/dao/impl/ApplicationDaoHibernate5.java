package com.jerry.hrsystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jerry.common.dao.impl.BaseDaoHibernate5;
import com.jerry.hrsystem.dao.ApplicationDao;
import com.jerry.hrsystem.domain.Application;
import com.jerry.hrsystem.domain.Employee;

@Component
public class ApplicationDaoHibernate5 extends BaseDaoHibernate5<Application> implements ApplicationDao
{
	public List<Application> findByEmp(Employee emp)
	{
		return find("select a from Application as a where " + "a.attend.employee = ?0", emp);
	}
}
