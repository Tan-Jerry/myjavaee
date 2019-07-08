package com.jerry.hrsystem.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jerry.hrsystem.dao.*;
import com.jerry.hrsystem.domain.*;
import com.jerry.hrsystem.service.EmpService;
import com.jerry.hrsystem.vo.*;

@Service
@Transactional
public class EmpServiceImpl implements EmpService
{
	@Autowired
	private ApplicationDao appDao;
	@Autowired
	private AttendDao attendDao;
	@Autowired
	private AttendTypeDao typeDao;
//	@Autowired
//	private CheckBackDao checkDao;
	@Autowired
	private EmployeeDao empDao;
	@Autowired
	private ManagerDao mgrDao;
	@Autowired
	private PaymentDao payDao;
	
	@Override
	public int validLogin(Manager mgr)
	{
		if (mgrDao.findByNameAndPass(mgr).size() >= 1)
		{
			return LOGIN_MGR;
		}
		else if (empDao.findByNameAndPass(mgr).size() >= 1)
		{
			return LOGIN_EMP;
		}
		else
		{
			return LOGIN_FAIL;
		}
	}

	@Override
	public void autoPunch()
	{
		System.out.println("Auto insert unattend record.");
		List<Employee> emps = empDao.findAll(Employee.class);
		
		String dutyDay = new java.sql.Date(System.currentTimeMillis()).toString();
		
		for (Employee e : emps)
		{
			AttendType attendType = typeDao.get(AttendType.class, 6);
			Attend attend = new Attend();
			
			attend.setDutyDay(dutyDay);
			attend.setType(attendType);
			
			if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < AM_LIMIT)
			{
				attend.setCome(true);
			}
			else
			{
				attend.setCome(false);
			}
			attend.setEmployee(e);
			
			attendDao.save(attend);
		}
	}

	@Override
	public void autoPay()
	{
		System.out.println("Auto insert payment");
		
		List<Employee> emps = empDao.findAll(Employee.class);
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -15);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String payMounth = sdf.format(c.getTime());
		
		for (Employee e : emps)
		{
			Payment pay = new Payment();
			
			double amount = e.getSalary();
			
			List<Attend> attends = attendDao.findByEmpAndMounth(e, payMounth);
			for (Attend a : attends)
			{
				amount += a.getType().getAmerce();
			}
			
			pay.setPayAmount(amount);
			pay.setPayMounth(payMounth);
			pay.setEmployee(e);
			payDao.save(pay);
		}
	}

	@Override
	public int validPunch(String user, String dutyDay)
	{
		Employee emp = empDao.findByName(user);
		if (emp == null) return NO_PUNCH;
		
		List<Attend> attends = attendDao.findByempAndDutyDate(emp, dutyDay);
		// system not inset a empty punch record, user cannot punch.
		if (attends == null || attends.size() <= 0)
		{
			return NO_PUNCH;
		}
		else if (attends.size() == 1 && attends.get(0).isCome() && attends.get(0).getPunchTime() == null)
		{
			return COME_PUNCH;
		}
		else if (attends.size() == 1 && attends.get(0).getPunchTime() == null)
		{
			return LEAVE_PUNCH;
		}
		else if (attends.size() == 2)
		{
			if (attends.get(0).getPunchTime() == null
					&& attends.get(1).getPunchTime() == null)
				{
					return BOTH_PUNCH;
				}
				else if (attends.get(1).getPunchTime() == null)
				{
					return LEAVE_PUNCH;
				}
				else
				{
					return NO_PUNCH;
				}
		}
		
		return NO_PUNCH;
	}

	@Override
	public int punch(String user, String dutyDay, boolean isCome)
	{
		Employee emp = empDao.findByName(user);
		if (emp == null)
		{
			return PUNCH_FAIL;
		}
		
		Attend attend = attendDao.findByEmpAndDutyDayAndCome(emp , dutyDay , isCome);
		if (attend == null)
		{
			return PUNCH_FAIL;
		}
		
		if (attend.getPunchTime() != null)
		{
			return PUNCHED;
		}
		
		System.out.println("============Punch==========");
		
		int punchHour = Calendar.getInstance()
				.get(Calendar.HOUR_OF_DAY);
		attend.setPunchTime(new Date());
		
		if (isCome)
		{
			if (punchHour < COME_LIMIT)
			{
				attend.setType(typeDao.get(AttendType.class , 1));
			}
			else if (punchHour < LATE_LIMIT)
			{
				attend.setType(typeDao.get(AttendType.class , 4));
			}
		}
		else
		{
			if (punchHour >= LEAVE_LIMIT)
			{
				attend.setType(typeDao.get(AttendType.class , 1));
			}
			else if (punchHour >= EARLY_LIMIT)
			{
				attend.setType(typeDao.get(AttendType.class , 5));
			}
		}
		attendDao.update(attend);
		return PUNCH_SUCC;
	}

	@Override
	public List<PaymentBean> empSalary(String empName)
	{
		Employee emp = empDao.findByName(empName);
		List<Payment> pays = payDao.findByEmp(emp);
		List<PaymentBean> result = new ArrayList<PaymentBean>();
		for (Payment p : pays )
		{
			result.add(new PaymentBean(p.getPayMounth()
				,p.getPayAmount()));
		}
		return result;
	}

	@Override
	public List<AttendBean> unAttend(String empName)
	{
		AttendType type = typeDao.get(AttendType.class , 1);
		Employee emp = empDao.findByName(empName);
		List<Attend> attends = attendDao.findByEmpUnAttend(emp, type);
		List<AttendBean> result = new ArrayList<AttendBean>();
		for (Attend att : attends )
		{
			result.add(new AttendBean(att.getId() , att.getDutyDay()
				, att.getType().getName() , att.getPunchTime()));
		}
		return result;
	}

	@Override
	public List<AttendType> getAllType()
	{
		return typeDao.findAll(AttendType.class);
	}

	@Override
	public boolean addApplication(int attId, int typeId, String reason)
	{
		System.out.println("--------------" + attId);
		System.out.println("~~~~" + typeId);
		System.out.println("~~~~" + reason);

		Application app = new Application();

		Attend attend = attendDao.get(Attend.class , attId);
		AttendType type = typeDao.get(AttendType.class , typeId);
		app.setAttend(attend);
		app.setType(type);
		if (reason != null)
		{
			app.setReason(reason);
		}
		System.out.println("====aaaaaaaaa====");
		appDao.save(app);
		return true;
	}
}
