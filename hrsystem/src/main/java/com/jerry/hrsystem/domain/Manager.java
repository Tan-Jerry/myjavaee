package com.jerry.hrsystem.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@DiscriminatorValue(value = "2")
public class Manager extends Employee
{
	@Column(name = "dept_name", length = 50)
	private String dept;
	
	@OneToMany(targetEntity = Employee.class, mappedBy = "manager")
	private Set<Employee> employees = new HashSet<>();
	
	@OneToMany(targetEntity = CheckBack.class, mappedBy = "manager")
	private Set<CheckBack> checks = new HashSet<>();
	
	public Manager()
	{
		
	}

	public Manager(String dept, Set<Employee> employees, Set<CheckBack> checks)
	{
		super();
		this.dept = dept;
		this.employees = employees;
		this.checks = checks;
	}

	public String getDept()
	{
		return dept;
	}
	public void setDept(String dept)
	{
		this.dept = dept;
	}

	public Set<Employee> getEmployees()
	{
		return employees;
	}
	public void setEmployees(Set<Employee> employees)
	{
		this.employees = employees;
	}

	public Set<CheckBack> getChecks()
	{
		return checks;
	}
	public void setChecks(Set<CheckBack> checks)
	{
		this.checks = checks;
	}
}
