package com.jerry.action;

import com.jerry.dao.DaoUser;
import com.jerry.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport
{

	private String username;
	private String password;
	
	
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


	@Override
	public String execute() throws Exception
	{
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		DaoUser daoUser = new DaoUser();
		User user = daoUser.getUser(getUsername());
		
		if (user != null)
		{
			if (user.getPassword().equals(getPassword()))
			{
				ActionContext.getContext().getSession().put("user", getUsername());
				return SUCCESS;
			}
		}

		return ERROR;
	}

	public String regist() throws Exception
	{
		DaoUser daoUser = new DaoUser();
		User user = daoUser.getUser(getUsername());
		
		if (user == null)
		{
			user = new User();
			user.setUsername(getUsername());
			user.setPassword(getPassword());
			
			daoUser.addUser(user);
			
			ActionContext.getContext().getSession().put("user", getUsername());
			return SUCCESS;
		}

		return ERROR;
	}
}
