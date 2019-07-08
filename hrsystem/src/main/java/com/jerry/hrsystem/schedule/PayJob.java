package com.jerry.hrsystem.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.jerry.hrsystem.service.EmpService;

@Component
public class PayJob extends QuartzJobBean
{
	private boolean isRunning = false;
	
	@Autowired
	private EmpService empMgr;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException
	{
		if (!isRunning)
		{
			System.out.println("Begin schedule auto payment.");
			isRunning = true;
			empMgr.autoPay();
			isRunning = false;
		}
	}

}
