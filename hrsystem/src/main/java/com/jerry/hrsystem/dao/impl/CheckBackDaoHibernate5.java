package com.jerry.hrsystem.dao.impl;

import org.springframework.stereotype.Component;

import com.jerry.common.dao.impl.BaseDaoHibernate5;
import com.jerry.hrsystem.dao.CheckBackDao;
import com.jerry.hrsystem.domain.CheckBack;

@Component
public class CheckBackDaoHibernate5 extends BaseDaoHibernate5<CheckBack> implements CheckBackDao
{

}
