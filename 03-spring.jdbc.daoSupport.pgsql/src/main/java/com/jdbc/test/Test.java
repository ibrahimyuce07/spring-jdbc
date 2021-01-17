package com.jdbc.test;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.model.Employee;
import com.jdbc.repository.EmployeeRepo;
import com.jdbc.repository.EmployeeRepoImpl;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmployeeRepo employeeRepo = applicationContext.getBean("employeeRepoImpl", EmployeeRepoImpl.class);
		
		//employeeRepo.createEmployeeTable();
		
		Employee employee = new Employee(101, "İbrahim", "Yüce", createCustomDate(19, 05, 1996), "239423433");
		employeeRepo.save(employee);
		
		applicationContext.close();
	}
	
	public static Date createCustomDate(int day, int month, int year) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month-1); //bc it's zero based
		calendar.set(Calendar.YEAR, year);

		return calendar.getTime();
	}
	
}
