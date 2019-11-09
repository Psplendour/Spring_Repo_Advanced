package com.pk.dao.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.pk.dao.EmployeeDAO;
import com.pk.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
	private JdbcTemplate jdbcTemplet;
	
    public void setJdbcTemplet(JdbcTemplate jdbcTemplet) {
		this.jdbcTemplet = jdbcTemplet;
	}

	@Override
	public void createEmployee(Employee employee) {
		//String SQL="Insert into Employee_table(EmployeeID,EmployeeName,Email,Salary,Gender) values(?,?,?,?,?)";
		//int update = jdbcTemplet.update(SQL,new Object[]{employee.getEmployeeID(),employee.getEmployeeName(),employee.getEmail(),employee.getSalary(),employee.getGender()});
        int update = jdbcTemplet.update("Insert into Employee_table(EmployeeID,EmployeeName,Email,Salary,Gender) values(?,?,?,?,?)", employee.getEmployeeID(),employee.getEmployeeName(),employee.getEmail(),employee.getSalary(),employee.getGender());
		if(update>0)
        {
        	System.out.println("New Employee is created.....:)");
        }
	}

	@Override
	public Employee getEmployeeID(int employeeID) {
		String SQL="select * from Employee_table where employeeID=?";
	    Employee employee = jdbcTemplet.queryForObject(SQL, new EmployeerowMapper(),employeeID);
		return employee;
	}

	@Override
	public void deleteEmployeeById(int employeeID) {
		String SQL="Delete from Employee_table where employeeID=?";
		int update = jdbcTemplet.update(SQL,employeeID);
		if(update>0){
			System.out.println("Data for Employee whose EmployeeID "+employeeID +"  has been deleted");
		}

	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int employeeID) {
		String SQL="update Employee_table set email=? where employeeID=?";
		int update = jdbcTemplet.update(SQL,newEmail,employeeID);
		if(update>0){
			System.out.println("Email has been updated for The Employee whose ID is  "+employeeID);
		}

	}
	

	@Override
	public List<Employee> getAllEmployeeDetails() {
		String SQL ="select * from Employee_table";
		List<Employee> list = jdbcTemplet.query(SQL,new EmployeerowMapper());
		return list;
	}

}
