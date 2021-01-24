package com.jdbc.myapp.dao;

import java.util.List;

import com.jdbc.myapp.model.Person;

public interface PersonDao {

	List<Person> getPersonList();
	
	public void createPerson(Person person);

	//public void deletePerson(int theId);

	public Person getPerson(int theId);
}
