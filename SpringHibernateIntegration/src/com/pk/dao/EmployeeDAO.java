package com.pk.dao;
import java.util.List;
import com.pk.model.Employee;
    public interface EmployeeDAO {
	public abstract void createEmployee(Employee employee);
    public abstract Employee getEmployeeID(int employeeID);
    public abstract void  deleteEmployeeById(int employeeID);
    public abstract void  updateEmployeeEmailById(String newEmail,int employeeID);
    public abstract List<Employee> getAllEmployeeDetails();
}
