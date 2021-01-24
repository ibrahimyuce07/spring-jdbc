package com.jdbc.myapp.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jdbc.myapp.dao.PersonDao;
import com.jdbc.myapp.model.Person;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao;
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	@Transactional
	public List<Person> getPersonList() {
		return personDao.getPersonList();
	}

	@Override
	@Transactional
	public void createPerson(Person person) {
		personDao.createPerson(person);
	}
	
	@Override
	@Transactional
	public Person getPerson(int theId) {
		return personDao.getPerson(theId);
	}
}

