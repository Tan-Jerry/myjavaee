package com.jerry.hrsystem.dao;

import java.util.List;

import com.jerry.common.dao.BaseDao;
import com.jerry.hrsystem.domain.Application;
import com.jerry.hrsystem.domain.Employee;

public interface ApplicationDao extends BaseDao<Application>
{

	List<Application> findByEmp(Employee emp);

}
