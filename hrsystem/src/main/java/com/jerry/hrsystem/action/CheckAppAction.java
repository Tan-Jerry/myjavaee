package com.jerry.hrsystem.action;

import com.opensymphony.xwork2.*;
import org.springframework.stereotype.Controller;

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
public class CheckAppAction extends MgrBaseAction
{
	// ��Ҫ�����������ID
	private int appid;
	// ��װ������
	private String result;
	// appid��setter��getter����
	public void setAppid(int appid)
	{
		this.appid = appid;
	}
	public int getAppid()
	{
		return this.appid;
	}

	// result��setter��getter����
	public void setResult(String result)
	{
		this.result = result;
	}
	public String getResult()
	{
		return this.result;
	}

	public String execute()
		throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		// ͨ������
		if (result.equals("pass"))
		{
			mgr.check(appid, mgrName, true);
		}
		// �ܾ�����
		else if (result.equals("deny"))
		{
			mgr.check(appid, mgrName, false);
		}
		else
		{
			throw new Exception("������ʧ");
		}
		return SUCCESS;
	}
}