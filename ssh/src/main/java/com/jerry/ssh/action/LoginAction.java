package com.jerry.ssh.action;

import com.jerry.ssh.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{
	private String username;
	private String password;
	
	private LoginService loginService;
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}

	public LoginService getLoginService()
	{
		return loginService;
	}
	public void setLoginService(LoginService loginService)
	{
		this.loginService = loginService;
	}
	
	@Override
	public String execute() throws Exception
	{
		if (loginService.validLogin(username, password) > 0)
		{
			addActionMessage("Wow, Integrate Success!");
			return SUCCESS;
		}
		
		return ERROR;
	}

}
