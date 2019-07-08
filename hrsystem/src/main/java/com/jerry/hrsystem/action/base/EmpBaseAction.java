package com.jerry.hrsystem.action.base;

import com.opensymphony.xwork2.ActionSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jerry.hrsystem.service.EmpService;


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
public class EmpBaseAction extends ActionSupport
{
	protected EmpService mgr;
	// ����ע��ҵ���߼�����������setter����
	public void setEmpManager(EmpService mgr)
	{
		this.mgr = mgr;
	}
}