package com.jerry.hrsystem.dao;

import java.util.List;

import com.jerry.common.dao.BaseDao;
import com.jerry.hrsystem.domain.Employee;
import com.jerry.hrsystem.domain.Payment;

public interface PaymentDao extends BaseDao<Payment>
{
	List<Payment> findByEmp(Employee emp);

	Payment findByMonthAndEmp(String payMonth , Employee emp);
}
