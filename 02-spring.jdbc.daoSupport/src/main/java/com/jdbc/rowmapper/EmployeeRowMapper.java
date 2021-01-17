package com.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.jdbc.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		int employeeId = rs.getInt("employeeId");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		Date birthDate = rs.getDate("birthDate");
		String employeeNumber = rs.getString("employeeNumber");
		
		Employee employee = new Employee(employeeId, firstName, lastName, birthDate, employeeNumber);
		
	return null;
}
}
