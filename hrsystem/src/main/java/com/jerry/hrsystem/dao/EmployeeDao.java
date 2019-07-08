package com.jerry.hrsystem.dao;

import java.util.List;

import com.jerry.common.dao.BaseDao;
import com.jerry.hrsystem.domain.Employee;

public interface EmployeeDao extends BaseDao<Employee>
{

	List<Employee> findByNameAndPass(Employee emp);

	Employee findByName(String name);

}
