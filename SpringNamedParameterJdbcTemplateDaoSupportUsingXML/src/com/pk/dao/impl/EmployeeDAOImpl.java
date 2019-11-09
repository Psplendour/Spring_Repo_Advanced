package com.pk.dao.impl;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import com.pk.dao.EmployeeDAO;
import com.pk.model.Employee;

public class EmployeeDAOImpl extends NamedParameterJdbcDaoSupport implements EmployeeDAO {
	
	@Override
	public void createEmployee(Employee employee) {
		String SQL = "Insert into Employee_table(EmployeeID,EmployeeName,Email,Salary,Gender) values(:EmpID,:EmpName,:Email,:Sal,:Gen)";
		MapSqlParameterSource inputMap = new MapSqlParameterSource();
		inputMap.addValue("EmpID", employee.getEmployeeID());
		inputMap.addValue("EmpName", employee.getEmployeeName());
		inputMap.addValue("Email", employee.getEmail());
		inputMap.addValue("Sal", employee.getSalary());
		inputMap.addValue("Gen", employee.getGender());

		int update = getNamedParameterJdbcTemplate().update(SQL, inputMap);
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
		Employee employee = getNamedParameterJdbcTemplate().queryForObject(SQL,
				inputMap2, new EmployeerowMapper());
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeID) {
		String SQL = "Delete from Employee_table where employeeID=:EmpID";
		MapSqlParameterSource mapInput = new MapSqlParameterSource();
		mapInput.addValue("EmpID", employeeID);

		int update = getNamedParameterJdbcTemplate().update(SQL, mapInput);

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
		int update = getNamedParameterJdbcTemplate().update(SQL, mapInput);

		if (update > 0) {
			System.out
					.println("Email has been updated for The Employee whose ID is  "
							+ employeeID);
		}
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		String SQL = "select * from Employee_table";
		List<Employee> list = getNamedParameterJdbcTemplate().query(SQL,
				new EmployeerowMapper());
		return list;
	}
}
