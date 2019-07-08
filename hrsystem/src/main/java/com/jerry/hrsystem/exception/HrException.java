package com.jerry.hrsystem.exception;

public class HrException extends RuntimeException
{
	private static final long serialVersionUID = 68L;
	
	public HrException(){}
	public HrException(String msg)
	{
		super(msg);
	}
}
