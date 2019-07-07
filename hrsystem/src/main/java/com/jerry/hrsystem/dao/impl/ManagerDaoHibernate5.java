package com.jerry.hrsystem.dao.impl;

import org.springframework.stereotype.Component;

import com.jerry.common.dao.impl.BaseDaoHibernate5;
import com.jerry.hrsystem.dao.ManagerDao;
import com.jerry.hrsystem.domain.Manager;

@Component
public class ManagerDaoHibernate5 extends BaseDaoHibernate5<Manager> implements ManagerDao
{

}
