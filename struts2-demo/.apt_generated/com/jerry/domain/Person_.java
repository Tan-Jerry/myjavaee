package com.jerry.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ {

	public static volatile SingularAttribute<Person, Address> address;
	public static volatile ListAttribute<Person, String> schools;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, Integer> id;
	public static volatile SingularAttribute<Person, Integer> age;

	public static final String ADDRESS = "address";
	public static final String SCHOOLS = "schools";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String AGE = "age";

}

