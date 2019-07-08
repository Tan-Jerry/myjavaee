package com.jerry.hrsystem.dao;

import java.util.List;

import com.jerry.common.dao.BaseDao;
import com.jerry.hrsystem.domain.Manager;

public interface ManagerDao extends BaseDao<Manager>
{
	List<Manager> findByNameAndPass(Manager mgr);

	Manager findByName(String name);
}
