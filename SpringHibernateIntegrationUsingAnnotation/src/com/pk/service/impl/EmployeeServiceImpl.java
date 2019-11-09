package com.pk.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pk.dao.EmployeeDAO;
import com.pk.model.Employee;
import com.pk.service.EmployeeService;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
	private EmployeeDAO employeeDAO;
    
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.createEmployee(employee);

	}

	@Override
	public Employee fetchEmployeeID(int employeeID) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeID(employeeID);
	}

	@Override
	public void deleteEmployeeById(int employeeID) {
		employeeDAO.deleteEmployeeById(employeeID);

	}

	@Override
	public void updateEmployeeEmailById(String newEmail, int employeeID) {
		employeeDAO.updateEmployeeEmailById(newEmail, employeeID);

	}

	@Override
	public List<Employee> getAllEmployeeInfo() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployeeDetails();
	}

}
