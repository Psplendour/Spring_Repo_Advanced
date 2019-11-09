package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.EmployeeDAO;
import com.pk.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void createEmployee(Employee employee) {
		String SQL = "Insert into Employee_table(EmployeeID,EmployeeName,Email,Salary,Gender) values(:EmpID,:EmpName,:Email,:Sal,:Gen)";
		MapSqlParameterSource inputMap = new MapSqlParameterSource();
		inputMap.addValue("EmpID", employee.getEmployeeID());
		inputMap.addValue("EmpName", employee.getEmployeeName());
		inputMap.addValue("Email", employee.getEmail());
		inputMap.addValue("Sal", employee.getSalary());
		inputMap.addValue("Gen", employee.getGender());

		int update = namedParameterJdbcTemplate.update(SQL, inputMap);
		if (update > 0) {
			System.out.println("New Employee is created.....:)");
		}
	}

	@Override
	public Employee getEmployeeID(int employeeID) {
		String SQL = "select * from Employee_table where employeeID=:empID";

		// Map<String,Object> inputMap1 =new HashMap<>();
		// inputMap1.put("empID", employeeID);

		MapSqlParameterSource inputMap2 = new MapSqlParameterSource();
		inputMap2.addValue("empID", employeeID);
		Employee employee = namedParameterJdbcTemplate.queryForObject(SQL,
				inputMap2, new EmployeerowMapper());
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeID) {
		String SQL = "Delete from Employee_table where employeeID=:EmpID";
		MapSqlParameterSource mapInput = new MapSqlParameterSource();
		mapInput.addValue("EmpID", employeeID);

		int update = namedParameterJdbcTemplate.update(SQL, mapInput);

		if (update > 0) {
			System.out.println("Data for Employee whose EmployeeID "
					+ employeeID + "  has been deleted");
		}
	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int employeeID) {
		String SQL = "update Employee_table set email=:Nemail where employeeID=:EmpID";
		MapSqlParameterSource mapInput = new MapSqlParameterSource();
		mapInput.addValue("Nemail", newEmail);
		mapInput.addValue("EmpID", employeeID);
		int update = namedParameterJdbcTemplate.update(SQL, mapInput);

		if (update > 0) {
			System.out
					.println("Email has been updated for The Employee whose ID is  "
							+ employeeID);
		}
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		String SQL = "select * from Employee_table";
		List<Employee> list = namedParameterJdbcTemplate.query(SQL,
				new EmployeerowMapper());
		return list;
	}
}
