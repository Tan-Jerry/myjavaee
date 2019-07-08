package com.jerry.hrsystem.action.authority;

import com.opensymphony.xwork2.*;

import com.opensymphony.xwork2.interceptor.*;

import com.jerry.hrsystem.action.WebConstant;

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
public class EmpAuthorityInterceptor extends AbstractInterceptor
{
	public String intercept(ActionInvocation invocation)
		throws Exception
	{
		// ����ActionContextʵ��
		ActionContext ctx = ActionContext.getContext();
		// ��ȡHttpSession�е�level����
		String level = (String)ctx.getSession()
			.get(WebConstant.LEVEL);
		// ���level��Ϊnull����levelΪemp��mgr
		if (level != null && (level.equals(WebConstant.EMP_LEVEL)
			|| level.equals(WebConstant.MGR_LEVEL)))
		{
			return invocation.invoke();
		}
		return Action.LOGIN;
	}
}