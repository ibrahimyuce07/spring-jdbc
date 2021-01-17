package com.jdbc.repository;

import java.util.List;

import com.jdbc.model.Employee;

public interface EmployeeRepo {

	boolean createEmployeeTable();
	
	Employee save(Employee employee);
	
	Employee update(Employee employee);
	
	boolean deleteById(int id);
	
	Employee findById(int id);
	
	List<Employee> findEmployees();
	
	List<Employee> findEmployeesByName(String firstName);
	
}
