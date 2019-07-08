package com.jerry.hrsystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jerry.common.dao.impl.BaseDaoHibernate5;
import com.jerry.hrsystem.dao.EmployeeDao;
import com.jerry.hrsystem.domain.Employee;

@Component
public class EmployeeDaoHibernate5 extends BaseDaoHibernate5<Employee> implements EmployeeDao
{
	@Override
	public List<Employee> findByNameAndPass(Employee emp)
	{
		return find("select p from Employee p where p.name = ?0 and p.pass = ?1", emp.getName(), emp.getPass());
	}
	
	@Override
	public Employee findByName(String name)
	{
		List<Employee> emps = find("select e from Employee e where e.name = ?0", name);
		
		if (emps != null && emps.size() >= 1)
		{
			return emps.get(0);
		}
		return null;
	}
}
