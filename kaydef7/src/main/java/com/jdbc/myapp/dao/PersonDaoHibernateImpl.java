package com.jdbc.myapp.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.jdbc.myapp.model.Person;

public class PersonDaoHibernateImpl implements PersonDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Person> getPersonList() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		TypedQuery<Person> query = currentSession.createQuery("from Person", Person.class);
		List<Person> personList = query.getResultList();
		return personList;
	}

	@Override
	public void createPerson(Person person) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(person);
	}
	
	@Override
	public Person getPerson(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Person person = currentSession.get(Person.class, theId);
		return person;
	}
}
