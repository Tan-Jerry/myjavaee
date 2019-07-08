package com.jerry.hrsystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jerry.common.dao.impl.BaseDaoHibernate5;
import com.jerry.hrsystem.dao.PaymentDao;
import com.jerry.hrsystem.domain.Employee;
import com.jerry.hrsystem.domain.Payment;

@Component
public class PaymentDaoHibernate5 extends BaseDaoHibernate5<Payment> implements PaymentDao
{
	public List<Payment> findByEmp(Employee emp)
	{
		return find("select p from Payment as p where p.employee=?0" , emp);
	}

	public Payment findByMonthAndEmp(String payMonth
		 , Employee emp)
	{
		List<Payment> pays = find("select p from Payment as p where"
			+ " p.employee=?0 and p.payMonth=?1" , emp , payMonth);
		if (pays != null && pays.size() > 0)
		{
			return pays.get(0);
		}
		return null;
	}
}
