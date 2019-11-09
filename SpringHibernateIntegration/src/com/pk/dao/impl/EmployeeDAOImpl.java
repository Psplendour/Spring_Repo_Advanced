package com.pk.dao.impl;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.pk.dao.EmployeeDAO;
import com.pk.model.Employee;
@SuppressWarnings("deprecation")
public class EmployeeDAOImpl implements EmployeeDAO {    
	private HibernateTemplate hibernateTemplate;   
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public void createEmployee(Employee employee) {
		hibernateTemplate.save(employee);		
	}
	@Override
	public Employee getEmployeeID(int employeeID) {
	    Employee employee = hibernateTemplate.get(Employee.class,employeeID);
		return employee;
	}
	@Override
	public void deleteEmployeeById(int employeeID) {
		Employee employee=new Employee();
		employee.setEmployeeID(employeeID);
		hibernateTemplate.delete(employee);		
	}
	@Override
	//If you want to update any record then we have to fetch first then have to update
	public void updateEmployeeEmailById(String newEmail, int employeeID) {
		Employee employee = hibernateTemplate.get(Employee.class,employeeID);
		employee.setEmail(newEmail);
		hibernateTemplate.update(employee);	
	}
	@Override
	public List<Employee> getAllEmployeeDetails() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Employee.class);
		@SuppressWarnings("unchecked")
		List<Employee> EmpList = (List<Employee>) hibernateTemplate.findByCriteria(criteria);
		return EmpList;
	}   
}
