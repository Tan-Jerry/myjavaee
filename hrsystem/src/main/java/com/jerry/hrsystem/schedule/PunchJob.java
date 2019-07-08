package com.jerry.hrsystem.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.jerry.hrsystem.service.EmpService;

@Component
public class PunchJob extends QuartzJobBean
{
	private boolean isRunning = false;
	
	@Autowired
	private EmpService empMgr;
	
	public void executeInternal(JobExecutionContext ctx)
			throws JobExecutionException
		{
			if (!isRunning)
			{
				System.out.println("Begin schedule auto punch");
				isRunning = true;
				empMgr.autoPunch();
				isRunning = false;
			}
		}
}
