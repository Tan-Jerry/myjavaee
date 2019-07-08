package com.jerry.hrsystem.service.impl;

import com.jerry.hrsystem.dao.*;
import com.jerry.hrsystem.domain.*;
import com.jerry.hrsystem.vo.*;
import com.jerry.hrsystem.exception.*;
import com.jerry.hrsystem.service.*;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MgrServiceImpl implements MgrService
{
	@Autowired
	private ApplicationDao appDao;
	@Autowired
	private AttendDao attendDao;
//	@Autowired
//	private AttendTypeDao typeDao;
	@Autowired
	private CheckBackDao checkDao;
	@Autowired
	private EmployeeDao empDao;
	@Autowired
	private ManagerDao mgrDao;
	@Autowired
	private PaymentDao payDao;

	public void addEmp(Employee emp , String mgr)throws HrException
	{
		Manager m = mgrDao.findByName(mgr);
		if (m == null)
		{
			throw new HrException("Are you manager? or you have not login?");
		}
		emp.setManager(m);
		empDao.save(emp);
	}

	public List<SalaryBean> getSalaryByMgr(String mgr)throws HrException
	{
		Manager m = mgrDao.findByName(mgr);
		if (m == null)
		{
			throw new HrException("Are you manager? or you have not login?\"");
		}
		Set<Employee> emps = m.getEmployees();
		if (emps == null || emps.size() < 1)
		{
			throw new HrException("There is no employee in you dept.");
		}
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH , -1);
		SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM");
		String payMonth = sdf.format(c.getTime());
		List<SalaryBean> result = new ArrayList<SalaryBean>();
		for (Employee e : emps)
		{
			Payment p = payDao.findByMonthAndEmp(payMonth , e);
			if (p != null)
			{
				result.add(new SalaryBean(e.getName()
					, p.getPayAmount()));
			}
		}
		return result;
	}

	public List<EmpBean> getEmpsByMgr(String mgr)
		throws HrException
	{
		Manager m = mgrDao.findByName(mgr);
		if (m == null)
		{
			throw new HrException("Are you manager? or you have not login?");
		}

		Set<Employee> emps = m.getEmployees();

		if (emps == null || emps.size() < 1)
		{
			throw new HrException("There is no employee in you dept.");
		}

		List<EmpBean> result = new ArrayList<EmpBean>();
		for (Employee e : emps)
		{
			result.add(new EmpBean(e.getName() ,
				e.getPass() , e.getSalary()));
		}
		return result;
	}

	public List<AppBean> getAppsByMgr(String mgr)throws HrException
	{
		Manager m = mgrDao.findByName(mgr);
		if (m == null)
		{
			throw new HrException("Are you manager? or you have not login?");
		}

		Set<Employee> emps = m.getEmployees();

		if (emps == null || emps.size() < 1)
		{
			throw new HrException("There is no employee in you dept.");
		}

		List<AppBean> result = new ArrayList<AppBean>();
		for (Employee e : emps)
		{

			List<Application> apps = appDao.findByEmp(e);
			if (apps != null && apps.size() > 0)
			{
				for (Application app : apps)
				{

					if (app.isResult() == false)
					{
						Attend attend = app.getAttend();
						result.add(new AppBean(app.getId() ,
							e.getName(), attend.getType().getName(),
							app.getType().getName(), app.getReason()));
					}
				}
			}
		}
		return result;
	}

	public void check(int appid, String mgrName, boolean result)
	{
		Application app = appDao.get(Application.class , appid);
		CheckBack check = new CheckBack();
		check.setApp(app);
		Manager manager = mgrDao.findByName(mgrName);
		if (manager == null)
		{
			throw new HrException("Are you manager? or you have not login?");
		}
		check.setManager(manager);

		if (result)
		{

			check.setResult(true);


			app.setResult(true);
			appDao.update(app);

			Attend attend = app.getAttend();
			attend.setType(app.getType());
			attendDao.update(attend);
		}
		else
		{

			check.setResult(false);
			app.setResult(true);
			appDao.update(app);
		}

		checkDao.save(check);
	}
}
