package com.jerry.hrsystem.dao;

import java.util.List;

import com.jerry.common.dao.BaseDao;
import com.jerry.hrsystem.domain.Attend;
import com.jerry.hrsystem.domain.AttendType;
import com.jerry.hrsystem.domain.Employee;

public interface AttendDao extends BaseDao<Attend>
{

	List<Attend> findByEmpAndMounth(Employee emp, String mounth);

	List<Attend> findByempAndDutyDate(Employee emp, String dutyDay);

	Attend findByEmpAndDutyDayAndCome(Employee emp, String dutyDay, boolean isCome);

	List<Attend> findByEmpUnAttend(Employee emp, AttendType type);

}
