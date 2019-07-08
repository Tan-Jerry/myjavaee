package com.jerry.hrsystem.action;

import com.opensymphony.xwork2.*;
import org.springframework.stereotype.Controller;

import com.jerry.hrsystem.service.EmpService;
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
public class ProcessPunchAction extends ActionSupport
{
	// ��Action��������ҵ���߼����
	private EmpService empMgr;
	// ����ע��ҵ���߼������setter����
	public void setEmpManager(EmpService empMgr)
	{
		this.empMgr = empMgr;
	}
	// �����ϰ�򿨵ķ���
	public String come()
		throws Exception
	{
		return process(true);
	}
	// �����°�򿨵ķ���
	public String leave()
		throws Exception
	{
		return process(false);
	}
	private String process(boolean isCome)
		throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String user = (String)ctx.getSession()
			.get(WebConstant.USER);
		System.out.println("-----��----" + user);
		String dutyDay = new java.sql.Date(
			System.currentTimeMillis()).toString();
		// ����ҵ���߼��������������
		int result = empMgr.punch(user ,dutyDay , isCome);
		switch(result)
		{
			case PUNCH_FAIL:
				addActionMessage("��ʧ��");
				break;
			case PUNCHED:
				addActionMessage("���Ѿ�������ˣ���Ҫ�ظ���");
				break;
			case PUNCH_SUCC:
				addActionMessage("�򿨳ɹ�");
				break;
		}
		return SUCCESS;
	}
}