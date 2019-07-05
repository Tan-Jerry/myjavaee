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
@Table(name = "application_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Application
{
	@Id
	@Column(name = "app_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "app_reason", length = 50)
	private String reason;
	
	@Column(name = "app_result")
	private boolean result;
	
	@ManyToOne(targetEntity = Attend.class)
	@JoinColumn(name = "attend_id", nullable = false)
	private Attend attend;
	
	@ManyToOne(targetEntity = AttendType.class)
	@JoinColumn(name = "type_id", nullable = false)
	private AttendType type;
	
	@OneToOne(targetEntity = CheckBack.class, mappedBy = "app")
	private CheckBack check;
	
	public Application()
	{
		
	}

	public Application(Integer id, String reason, boolean result, Attend attend, AttendType type, CheckBack check)
	{
		super();
		this.id = id;
		this.reason = reason;
		this.result = result;
		this.attend = attend;
		this.type = type;
		this.check = check;
	}

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getReason()
	{
		return reason;
	}
	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public boolean isResult()
	{
		return result;
	}
	public void setResult(boolean result)
	{
		this.result = result;
	}

	public Attend getAttend()
	{
		return attend;
	}
	public void setAttend(Attend attend)
	{
		this.attend = attend;
	}

	public AttendType getType()
	{
		return type;
	}
	public void setType(AttendType type)
	{
		this.type = type;
	}

	public CheckBack getCheck()
	{
		return check;
	}
	public void setCheck(CheckBack check)
	{
		this.check = check;
	}
}
