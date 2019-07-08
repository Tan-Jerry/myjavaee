package com.jerry.hrsystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jerry.hrsystem.config.AppConfig;
import com.jerry.hrsystem.dao.ApplicationDao;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class JPATest
{
	@Autowired
	private ApplicationDao appDao;
	
	@Autowired
	private Scheduler scheduler;
	
	@Test
	public void appDaoShouldNotBeNull()
	{
		assertNotNull(appDao);
	}
	
	@Test
	public void schedulerShouldNotBeNull()
	{
		assertNotNull(scheduler);
	}
}
