package com.jerry.hrsystem.action;

import org.springframework.stereotype.Controller;

import com.jerry.hrsystem.action.base.EmpBaseAction;
import java.util.*;

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
public class AppChangeAction extends EmpBaseAction
{
	private static final long serialVersionUID = 68;
	
	// ��װ�����춯���б�
	private List types;
	// types��setter��getter����
	public void setTypes(List types)
	{
		this.types = types;
	}
	public List getTypes()
	{
		return this.types;
	}
	// �����û�����
	public String execute()
		throws Exception
	{
		setTypes(mgr.getAllType());
		return SUCCESS;
	}
}