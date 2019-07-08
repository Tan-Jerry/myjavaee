package com.jerry.hrsystem.vo;

import java.io.Serializable;

public class EmpBean implements Serializable
{
	private static final long serialVersionUID = 68L;
	
	private String empName;
	private String empPass;
	private double amount;
	
	public EmpBean()
	{
		
	}

	public EmpBean(String empName, String empPass, double amount)
	{
		super();
		this.empName = empName;
		this.empPass = empPass;
		this.amount = amount;
	}

	public String getEmpName()
	{
		return empName;
	}

	public void setEmpName(String empName)
	{
		this.empName = empName;
	}

	public String getEmpPass()
	{
		return empPass;
	}

	public void setEmpPass(String empPass)
	{
		this.empPass = empPass;
	}

	public double getAmount()
	{
		return amount;
	}

	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	
}
