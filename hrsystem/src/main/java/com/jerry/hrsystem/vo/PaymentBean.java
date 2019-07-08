package com.jerry.hrsystem.vo;

import java.io.Serializable;

public class PaymentBean implements Serializable
{
	private static final long serialVersionUID = 68L;
	
	private String payMonth;
	private double amount;
	
	public PaymentBean()
	{
		super();
	}
	public PaymentBean(String payMonth, double amount)
	{
		super();
		this.payMonth = payMonth;
		this.amount = amount;
	}
	
	public String getPayMonth()
	{
		return payMonth;
	}
	public void setPayMonth(String payMonth)
	{
		this.payMonth = payMonth;
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
