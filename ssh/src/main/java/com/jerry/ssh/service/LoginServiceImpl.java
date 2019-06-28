package com.jerry.ssh.service;

public class LoginServiceImpl implements LoginService
{
	@Override
	public Integer validLogin(String username, String password)
	{
		if (username.equals("jerry") && password.equals("123456"))
		{
			return 1;
		}
		
		return -1;
	}
}
