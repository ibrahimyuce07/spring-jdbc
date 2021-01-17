package com.jdbc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.jdbc.model.Employee;
import com.jdbc.rowmapper.EmployeeRowMapper;

public class EmployeeRepoImpl extends JdbcDaoSupport implements EmployeeRepo {

	@Override
	public boolean createEmployeeTable() {

		String sorgu = "CREATE TABLE employee(employeeId INT NOT NULL, firstName VARCHAR(25), lastName VARCHAR(20), birthDate DATE, employeeNumber VARCHAR(12), PRIMARY KEY(employeeId))";

		try {

			this.getJdbcTemplate().execute(sorgu);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Employee save(Employee employee) {

		String sorgu = "INSERT INTO employee(employeeId, firstName, lastName, birthDate, employeeNumber) VALUES(?,?,?,?,?)";

		try {
			this.getJdbcTemplate().update(sorgu, new Object[] { employee.getEmployeeId(), employee.getFirstName(),
					employee.getLastName(), employee.getBirthDate(), employee.getEmployeeNumber() });
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
		return employee;
	}

	@Override
	public Employee update(Employee employee) {

		String sorgu = "UPDATE employee SET fistName = ?, lastName = ?, birthDate = ?, employeeNumber = ? WHERE employeeId = ?";

		try {
			this.getJdbcTemplate().update(sorgu, new Object[] { employee.getFirstName(), employee.getLastName(),
					employee.getBirthDate(), employee.getEmployeeNumber(), employee.getEmployeeId() });

		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}

		return employee;
	}

	@Override
	public boolean deleteById(int id) {
		String sorgu = "DELETE FROM employee WHERE employeeId = ?";

		try {
			this.getJdbcTemplate().update(sorgu, new Object[] { id });
		} catch (RuntimeException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public Employee findById(int id) {

		String sorgu = "SELECT * FROM employee WHERE employeeId = ?";

		Employee employee = null;
		try {
			employee = this.getJdbcTemplate().queryForObject(sorgu, new Object[] { id },
					new BeanPropertyRowMapper<>(Employee.class));
			// bunu kullanmak için POJO ile table column isimleri aynı olmalı.

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public List<Employee> findEmployees() {
		String sorgu = "SELECT * from employee";

		List<Employee> employees = new ArrayList<Employee>();

		try {

			employees = this.getJdbcTemplate().query(sorgu, new EmployeeRowMapper());

		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public List<Employee> findEmployeesByName(String firstName) {

		String sorgu = "SELECT * FROM employee WHERE firstName = ?";
		List<Employee> employees = null;

		try {
			employees = this.getJdbcTemplate().query(sorgu, new Object[] {firstName}, new EmployeeRowMapper());
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return employees;
	}

}
