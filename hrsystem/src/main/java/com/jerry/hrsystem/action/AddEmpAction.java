package com.jerry.hrsystem.action;

import com.opensymphony.xwork2.*;
import org.springframework.stereotype.Controller;

import com.jerry.hrsystem.domain.*;
import com.jerry.hrsystem.action.base.MgrBaseAction;

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
public class AddEmpAction extends MgrBaseAction
{
	private static final long serialVersionUID = 68L;
	
	// ��������Ա���ĳ�Ա����
	private Employee emp;

	// emp��setter��getter����
	public void setEmp(Employee emp)
	{
		this.emp = emp;
	}
	public Employee getEmp()
	{
		return this.emp;
	}

	public String execute()
		throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		// ������û�
		mgr.addEmp(emp , mgrName);
		addActionMessage("����Ա���ɹ�");
		return SUCCESS;
	}
}