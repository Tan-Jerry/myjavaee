package com.jerry.hrsystem.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "attend_type_inf")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AttendType
{
	@Id
	@Column(name = "type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "type_name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "amerce_amount", nullable = false)
	private double amerce;
	
	public AttendType()
	{
		// TODO Auto-generated constructor stub
	}

	public AttendType(Integer id, String name, double amerce)
	{
		super();
		this.id = id;
		this.name = name;
		this.amerce = amerce;
	}

	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public double getAmerce()
	{
		return amerce;
	}
	public void setAmerce(double amerce)
	{
		this.amerce = amerce;
	}
}
