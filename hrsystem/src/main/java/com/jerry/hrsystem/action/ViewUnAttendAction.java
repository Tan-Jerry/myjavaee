package com.jerry.hrsystem.action;

import com.opensymphony.xwork2.*;
import org.springframework.stereotype.Controller;

import com.jerry.hrsystem.action.base.EmpBaseAction;
import com.jerry.hrsystem.vo.*;

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
public class ViewUnAttendAction extends EmpBaseAction
{
	private List<AttendBean> unAttend;
	// unAttend��setter��getter����
	public void setUnAttend(List<AttendBean> unAttend)
	{
		this.unAttend = unAttend;
	}
	public List<AttendBean> getUnAttend()
	{
		return this.unAttend;
	}
	public String execute()
		throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�user����
		String user = (String)ctx.getSession()
			.get(WebConstant.USER);
		List<AttendBean> result = mgr.unAttend(user);
		setUnAttend(result);
		return SUCCESS;
	}
}