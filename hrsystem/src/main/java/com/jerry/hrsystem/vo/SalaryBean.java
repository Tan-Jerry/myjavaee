package com.jerry.hrsystem.vo;

import java.io.Serializable;

public class SalaryBean implements Serializable
{
	private static final long serialVersionUID = 68L;
	
	private String empName;
	private double amount;
	
	public SalaryBean()
	{
		super();
	}
	public SalaryBean(String empName, double amount)
	{
		super();
		this.empName = empName;
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
	
	public double getAmount()
	{
		return amount;
	}
	public void setAmount(double amount)
	{
		this.amount = amount;
	}
	
	
}
