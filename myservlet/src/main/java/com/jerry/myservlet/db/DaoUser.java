package com.jerry.myservlet.db;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DaoUser
{
	Connection getConnection() throws Exception;

	boolean insert(String sql, Object... args) throws Exception;

	ResultSet query(String sql, Object... args) throws Exception;

	void modify(String sql, Object... args) throws Exception;

	void closeConn() throws Exception;
}
