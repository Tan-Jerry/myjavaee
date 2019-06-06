package com.jerry.myservlet.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoUserImpl implements DaoUser
{
	private Connection conn;
	private String driver;
	private String url;
	private String username;
	private String pass;

	public DaoUserImpl()
	{
	}

	public DaoUserImpl(String driver, String url, String username, String pass)
	{
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.pass = pass;
	}
	
	public String getDriver()
	{
		return driver;
	}

	public void setDriver(String driver)
	{
		this.driver = driver;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}


	@Override
	public Connection getConnection() throws Exception
	{
		if (conn == null)
		{
			Class.forName(this.driver);
			conn = DriverManager.getConnection(url, username, pass);
		}
		
		return conn;
	}
	
	@Override
	public boolean insert(String sql, Object... args) throws Exception
	{
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		
		for (int i = 0; i < args.length; i++)
		{
			pstmt.setObject(i+1, args[i]);
		}
		if (pstmt.executeUpdate() != 1)
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public ResultSet query(String sql, Object... args) throws Exception
	{
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		
		for (int i = 0; i < args.length; i++)
		{
			pstmt.setObject(i+1, args[i]);
		}
		
		return pstmt.executeQuery();
	}
	
	@Override
	public void modify(String sql, Object... args) throws Exception
	{
		PreparedStatement pstmt = getConnection().prepareStatement(sql);
		
		for (int i = 0; i < args.length; i++)
		{
			pstmt.setObject(i+1, args[i]);
		}
		
		pstmt.executeUpdate();
		pstmt.close();
	}
	
	@Override
	public void closeConn() throws Exception
	{
		if (conn != null && !conn.isClosed())
		{
			conn.close();
		}
	}
}
