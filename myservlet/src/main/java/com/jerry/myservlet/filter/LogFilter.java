package com.jerry.myservlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "log"
	, urlPatterns = {"/*"}
	, initParams = {
			@WebInitParam(name = "loginPage", value = "/login.jsp"),
			@WebInitParam(name = "proLogin", value = "/login")
	})
public class LogFilter implements Filter
{

	private FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.config = filterConfig;
	}

	@Override
	public void destroy()
	{
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
//		ServletContext 		context  = request.getServletContext();
		HttpServletRequest 	hRequest = (HttpServletRequest)request;
		HttpSession			session  = hRequest.getSession(true);
		
		long before = System.currentTimeMillis();
		System.out.println("begin filter");
		System.out.println("Filter catch the URL:" + hRequest.getServletPath());
		
		String loginPage = config.getInitParameter("loginPage");
		String proLogin = config.getInitParameter("proLogin");
		
		if (session.getAttribute("user") == null
				&& !hRequest.getServletPath().endsWith(loginPage)
				&& !hRequest.getServletPath().endsWith(proLogin))
		{
			request.setAttribute("tip", "you must be login first.");
			request.getRequestDispatcher(loginPage).forward(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
		
		long after = System.currentTimeMillis();
		System.out.println("end filter");
		System.out.println("the target:" + hRequest.getRequestURI() + "	handle time: " + (after - before));
	}

}
