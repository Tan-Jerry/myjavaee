package com.jerry.hrsystem.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;
import org.springframework.stereotype.Controller;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class LogoutAction extends ActionSupport
	implements ServletRequestAware
{
	// ����һ��HttpServletRequest����
	private HttpServletRequest request;
	// ʵ��ServletRequestAware�ӿڱ�����д�ķ���
	public void setServletRequest(
		HttpServletRequest request)
	{
		this.request = request;
	}
	public String execute()
		throws Exception
	{
		// ��ȡHttpSession
		HttpSession session = request.getSession();
		// ʹSessionʧЧ
		session.invalidate();
		return SUCCESS;
	}
}