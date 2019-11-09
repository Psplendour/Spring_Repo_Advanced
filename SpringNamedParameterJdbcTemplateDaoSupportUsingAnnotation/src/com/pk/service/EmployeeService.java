package com.pk.service;
import java.util.List;
import com.pk.model.Employee;
public interface EmployeeService {
	public abstract void addEmployee(Employee employee);
    public abstract Employee fetchEmployeeID(int employeeID);
    public abstract void  deleteEmployeeById(int employeeID);
    public abstract void  updateEmployeeEmailById(String newEmail,int employeeID);
    public abstract List<Employee> getAllEmployeeInfo ();

}
