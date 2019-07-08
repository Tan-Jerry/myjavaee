package com.jerry.hrsystem.action;

import org.springframework.stereotype.Controller;

import com.jerry.hrsystem.action.base.EmpBaseAction;

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
public class ProcessAppAction extends EmpBaseAction
{
	// �����춯�ĳ���ID
	private int attId;
	// ϣ���ı䵽��������
	private int typeId;
	// ��������
	private String reason;
	// attId��setter��getter����
	public void setAttId(int attId)
	{
		this.attId = attId;
	}
	public int getAttId()
	{
		return this.attId;
	}

	// typeId��setter��getter����
	public void setTypeId(int typeId)
	{
		this.typeId = typeId;
	}
	public int getTypeId()
	{
		return this.typeId;
	}

	// reason��setter��getter����
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	public String getReason()
	{
		return this.reason;
	}

	// �����û�����
	public String execute()
		throws Exception
	{
		// �����춯����
		boolean result = mgr.addApplication(attId , typeId , reason);
		// �������ɹ�
		if(result)
		{
			addActionMessage("���Ѿ�����ɹ����ȴ���������");
		}
		else
		{
			addActionMessage("����ʧ�ܣ���ע�ⲻҪ�ظ�����");
		}
		return SUCCESS;
	}
}