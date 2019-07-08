package com.jerry.hrsystem.service;


import com.jerry.hrsystem.vo.*;
import com.jerry.hrsystem.domain.*;
import com.jerry.hrsystem.exception.*;

import java.util.*;

public interface MgrService
{

	void addEmp(Employee emp , String mgr)
		throws HrException;

	List<SalaryBean> getSalaryByMgr(String mgr);

	List<EmpBean> getEmpsByMgr(String mgr);

	List<AppBean> getAppsByMgr(String mgr);

	void check(int appid, String mgrName, boolean result);
}