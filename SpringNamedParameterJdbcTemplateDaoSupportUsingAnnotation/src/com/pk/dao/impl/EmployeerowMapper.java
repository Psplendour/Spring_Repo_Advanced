package com.pk.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.pk.model.Employee;
public class EmployeerowMapper implements RowMapper<Employee> {
    @Override
	public Employee mapRow(ResultSet rs,int rowNum) throws SQLException {
		Employee employee =new Employee();
		employee.setEmail(rs.getString("email"));
		employee.setEmployeeID(rs.getInt("employeeID"));
		employee.setEmployeeName(rs.getString("employeeName"));
		employee.setSalary(rs.getInt("salary"));
		employee.setGender(rs.getString("gender"));
		return employee;
	}
}

	 

