package com.jerry.hrsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "checkback_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CheckBack
{
	@Id
	@Column(name = "check_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "check_result", nullable = false)
	private boolean result;
	
	@Column(name = "check_reason", length = 255)
	private String reason;
	
	@OneToOne(targetEntity = Application.class)
	@JoinColumn(name = "app_id", nullable = false, unique = true)
	private Application app;
	
	@ManyToOne(targetEntity = Manager.class)
	@JoinColumn(name = "mgr_id", nullable = false)
	private Manager manager;
	
	public CheckBack()
	{
		
	}

	public CheckBack(Integer id, boolean result, String reason, Application app, Manager manager)
	{
		super();
		this.id = id;
		this.result = result;
		this.reason = reason;
		this.app = app;
		this.manager = manager;
	}

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}

	public boolean isResult()
	{
		return result;
	}
	public void setResult(boolean result)
	{
		this.result = result;
	}

	public String getReason()
	{
		return reason;
	}
	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public Application getApp()
	{
		return app;
	}
	public void setApp(Application app)
	{
		this.app = app;
	}
	
	public Manager getManager()
	{
		return manager;
	}
	public void setManager(Manager manager)
	{
		this.manager = manager;
	}
	
	
}
