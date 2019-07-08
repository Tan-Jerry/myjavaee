package com.jerry.hrsystem.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jerry.hrsystem.domain.Application;
import com.jerry.hrsystem.domain.Attend;
import com.jerry.hrsystem.domain.AttendType;
import com.jerry.hrsystem.domain.CheckBack;
import com.jerry.hrsystem.domain.Employee;
import com.jerry.hrsystem.domain.Manager;
import com.jerry.hrsystem.domain.Payment;
import com.jerry.hrsystem.service.EmpService;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = {"com.jerry"})
@EnableTransactionManagement
public class AppConfig
{
	@Bean(destroyMethod = "close")
	public DataSource dataSource() throws PropertyVetoException
	{
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		ds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setJdbcUrl("jdbc:sqlserver://localhost:65026;databaseName=J2EE_CRUD");
		ds.setUser("sa");
		ds.setPassword("Initial0");
		ds.setMaxPoolSize(200);
		ds.setMinPoolSize(2);
		ds.setInitialPoolSize(2);
		ds.setMaxIdleTime(20);
		
		return ds;
	}

	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) throws IOException
	{
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(dataSource);
		
		lsfb.setAnnotatedClasses(Application.class,
				                 Attend.class,
				                 AttendType.class,
				                 CheckBack.class,
				                 Employee.class,
				                 Manager.class,
				                 Payment.class);
		
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", true);
		props.put("hibernate.format_sql", true);
		props.put("hibernate.cache.use_second_level_cache", true);
		props.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		lsfb.setHibernateProperties(props);
		lsfb.afterPropertiesSet();
		SessionFactory sessionFactory = lsfb.getObject();
		return sessionFactory;
	}
	
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource)
	{
		return new DataSourceTransactionManager(dataSource);
	}
	
	@Autowired
	EmpService empManager;
	
	@Bean(name = "payTrigger")
	public CronTrigger cronTriggerPay() throws ParseException
	{
		CronTriggerFactoryBean ctfb = new CronTriggerFactoryBean();
		ctfb.setCronExpression("0 0 2 3 * ? *");
		
		JobDetailFactoryBean jdfb = new JobDetailFactoryBean();
		jdfb.setJobClass(com.jerry.hrsystem.schedule.PayJob.class);
		jdfb.setDurability(true);
		
		Map<String, Object> jobDataAsMap = new HashMap<String, Object>();
		jobDataAsMap.put("empMgr", empManager);
		jdfb.setJobDataAsMap(jobDataAsMap);
		
		jdfb.afterPropertiesSet();
		
		ctfb.setJobDetail(jdfb.getObject());
		
		ctfb.afterPropertiesSet();
		
		return ctfb.getObject();
	}
	
	@Bean(name = "punchTrigger")
	public CronTrigger cronTriggerPunch() throws ParseException
	{
		CronTriggerFactoryBean ctfb = new CronTriggerFactoryBean();
		ctfb.setCronExpression("0 0 7,12 ? * MON-FRI");
		
		JobDetailFactoryBean jdfb = new JobDetailFactoryBean();
		jdfb.setJobClass(com.jerry.hrsystem.schedule.PunchJob.class);
		jdfb.setDurability(true);
		
		Map<String, Object> jobDataAsMap = new HashMap<String, Object>();
		jobDataAsMap.put("empMgr", empManager);
		jdfb.setJobDataAsMap(jobDataAsMap);
		
		jdfb.afterPropertiesSet();
		
		ctfb.setJobDetail(jdfb.getObject());
		
		ctfb.afterPropertiesSet();
		
		return ctfb.getObject();
	}
	
	@Bean
	public Scheduler scheduler() throws Exception
	{
		SchedulerFactoryBean sfb = new SchedulerFactoryBean();
		sfb.setTriggers(cronTriggerPay(), cronTriggerPunch());
		sfb.afterPropertiesSet();
		return sfb.getObject();
	}
}
