package com.jerry.hrsystem.action;

import com.opensymphony.xwork2.*;
import org.springframework.stereotype.Controller;

import com.jerry.hrsystem.action.base.MgrBaseAction;

import java.util.List;
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
public class ViewAppAction extends MgrBaseAction
{
	private List apps;
	// apps��setter��getter����
	public void setApps(List apps)
	{
		this.apps = apps;
	}
	public List getApps()
	{
		return this.apps;
	}
	public String execute()
		throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		// ��ȡ��Ҫ����ǰ�������ȫ������
		setApps(mgr.getAppsByMgr(mgrName));
		return SUCCESS;
	}
}