package com.jerry.action;

import com.jerry.dao.DaoPerson;
import com.jerry.domain.Address;
import com.jerry.domain.Person;
import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport
{
	private String personname;
	private String school1;
	private String school2;
	
	public String getPersonname()
	{
		return personname;
	}
	public void setPersonname(String personname)
	{
		this.personname = personname;
	}
	public String getSchool1()
	{
		return school1;
	}
	public void setSchool1(String school1)
	{
		this.school1 = school1;
	}
	public String getSchool2()
	{
		return school2;
	}
	public void setSchool2(String school2)
	{
		this.school2 = school2;
	}
	
	@Override
	public String execute() throws Exception
	{
		DaoPerson daoPerson = new DaoPerson();
		
		Person person = new Person();
		
		person.setName(personname);
		person.setAge(28);
		person.getSchools().add(school1);
		person.getSchools().add(school2);
		
		Address address = new Address();
		address.setSddressDetail("No. 17 room 202");
		
		person.setAddress(address);
		
		daoPerson.addPerson(person);

		return SUCCESS;
	}
	
	
}
