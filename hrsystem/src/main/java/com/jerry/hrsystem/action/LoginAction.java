package com.jerry.hrsystem.action;

import com.opensymphony.xwork2.*;
import org.springframework.stereotype.Controller;

import com.jerry.hrsystem.domain.*;
import com.jerry.hrsystem.action.base.EmpBaseAction;
import static com.jerry.hrsystem.service.EmpService.*;

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
public class LoginAction extends EmpBaseAction
{
	// ����һ��������ΪԱ����¼�ɹ���Result��
	private final String EMP_RESULT = "emp";
	// ����һ��������Ϊ�����¼�ɹ���Result��
	private final String MGR_RESULT = "mgr";
	// ��װ�������
	private Manager manager;
	// ��¼����֤��
	private String vercode;
	// manager��setter��getter����
	public void setManager(Manager manager)
	{
		this.manager = manager;
	}
	public Manager getManager()
	{
		return this.manager;
	}

	// vercode��setter��getter����
	public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		return this.vercode;
	}

	// �����û�����
	public String execute()
		throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�rand����
		String ver2 = (String)ctx.getSession().get("rand");
		if (vercode.equalsIgnoreCase(ver2))
		{
			// ����ҵ���߼������������¼����
			int result = mgr.validLogin(getManager());
			// ��¼���Ϊ��ͨԱ��
			if (result == LOGIN_EMP)
			{
				ctx.getSession().put(WebConstant.USER
					, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL
					, WebConstant.EMP_LEVEL);
				addActionMessage("���Ѿ��ɹ���¼ϵͳ");
				return EMP_RESULT;
			}
			// ��¼���Ϊ����
			else if (result == LOGIN_MGR)
			{
				ctx.getSession().put(WebConstant.USER
					, manager.getName());
				ctx.getSession().put(WebConstant.LEVEL
					, WebConstant.MGR_LEVEL);
				addActionMessage("���Ѿ��ɹ���¼ϵͳ");
				return MGR_RESULT;
			}
			// �û��������벻ƥ��
			else
			{
				addActionMessage("�û���/���벻ƥ��");
				return ERROR;
			}
		}
		// ��֤�벻ƥ��
		addActionMessage("��֤�벻ƥ��,����������");
		return ERROR;
	}
}