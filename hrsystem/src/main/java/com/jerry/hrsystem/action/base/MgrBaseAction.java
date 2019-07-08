package com.jerry.hrsystem.action.base;

import com.opensymphony.xwork2.ActionSupport;

import com.jerry.hrsystem.service.MgrService;

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
public class MgrBaseAction extends ActionSupport
{
	protected MgrService mgr;

	public void setMgrManager(MgrService mgr)
	{
		this.mgr = mgr;
	}
}