package com.jdbc.myapp.service;

import java.util.List;

import com.jdbc.myapp.model.Person;

public interface PersonService {


	List<Person> getPersonList();
	
	public void createPerson(Person person);

	//public void deletePerson(int theId);

	public Person getPerson(int theId);
	
}
