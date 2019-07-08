package com.jerry.hrsystem.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jerry.common.dao.impl.BaseDaoHibernate5;
import com.jerry.hrsystem.dao.AttendDao;
import com.jerry.hrsystem.domain.Attend;
import com.jerry.hrsystem.domain.AttendType;
import com.jerry.hrsystem.domain.Employee;

@Component
public class AttendDaoHibernate5 extends BaseDaoHibernate5<Attend> implements AttendDao
{
	@Override
	public List<Attend> findByEmpAndMounth(Employee emp, String mounth)
	{
		return find("select a from Attend as a where" + "a.employee = ?0 and substring(a.dutyDay, 0, 7)=?1", emp, mounth);
	}
	
	@Override
	public List<Attend> findByempAndDutyDate(Employee emp, String dutyDay)
	{
		return find("from Attend as a where a.employee = ?0 and a.dutyDay = ?1", emp, dutyDay);
	}
	
	@Override
	public Attend findByEmpAndDutyDayAndCome(Employee emp, String dutyDay, boolean isCome)
	{
		List<Attend> al = findByempAndDutyDate(emp, dutyDay);
		
		if (al != null || al.size() > 1)
		{
			for (Attend attend: al)
			{
				if (attend.isCome() == isCome)
				{
					return attend;
				}
			}
		}
		
		return null;
	}
	
	@Override
	public List<Attend> findByEmpUnAttend(Employee emp, AttendType type)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String end = sdf.format(c.getTime());
		
		c.add(Calendar.DAY_OF_MONTH, -3);
		
		String start = sdf.format(c.getTime());
		
		return find("from Attend as a where a.employee=?0 and a.type != ?1 and a.dutyDay between ?2 and ?3", emp, type, start, end);
	}
}
