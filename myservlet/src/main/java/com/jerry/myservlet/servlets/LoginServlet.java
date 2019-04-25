package com.jerry.myservlet.servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jerry.myservlet.db.DaoUser;
import com.jerry.myservlet.db.DaoUserImpl;

@WebServlet(name="login", urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String errMsg = "";
		
		RequestDispatcher rd;
		
		String username = req.getParameter("username");
		String pass =req.getParameter("pass");
		
		try
		{
			DaoUser daoUser = new DaoUserImpl("com.sap.db.jdbc.Driver", "jdbc:sap://10.58.136.150:30015/?currentschema=U120212", "SYSTEM", "manager");
			
			ResultSet rs = daoUser.query("select \"userpwd\" from User where \"username\" = ?", username);
			
			if (rs.next())
			{
				if (rs.getString("userpwd").equals(pass))
				{
					HttpSession session = req.getSession(true);
					session.setAttribute("name", username);
					
					rd = req.getRequestDispatcher("/welcome.jsp");
					rd.forward(req, resp);
				}
				else
				{
					errMsg += "your password is not correct, please enter again...";
				}
			}
			else
			{
				errMsg += "User is not exist.";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if (errMsg != null && !errMsg.equals(""))
		{
			rd = req.getRequestDispatcher("/login.jsp");
			req.setAttribute("err", errMsg);
			rd.forward(req, resp);
		}
	}

}
