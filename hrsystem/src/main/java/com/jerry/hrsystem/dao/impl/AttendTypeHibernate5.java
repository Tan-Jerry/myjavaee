package com.jerry.hrsystem.dao.impl;

import org.springframework.stereotype.Component;

import com.jerry.common.dao.impl.BaseDaoHibernate5;
import com.jerry.hrsystem.dao.AttendTypeDao;
import com.jerry.hrsystem.domain.AttendType;

@Component
public class AttendTypeHibernate5 extends BaseDaoHibernate5<AttendType> implements AttendTypeDao
{

}
