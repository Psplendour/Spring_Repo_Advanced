package com.pk.dao.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.pk.dao.EmployeeDAO;
import com.pk.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @PersistenceContext
	private EntityManager entityManager;
    
    public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
    @Transactional
	@Override
	public void createEmployee(Employee employee) {
		entityManager.persist(employee);		
	}

	@Override
	public Employee getEmployeeID(int employeeID) {
		Employee employee = entityManager.find(Employee.class, employeeID);
		return employee;
	}
    
	@Transactional
	@Override
	public void deleteEmployeeById(int employeeID) {
		Employee employee = entityManager.find(Employee.class,employeeID);
		if(employee!=null)
		{
			entityManager.remove(employee );
		}		
	}
    @Transactional
	@Override
	public void updateEmployeeEmailById(String newEmail, int employeeID) {
		Employee employee = entityManager.find(Employee.class,employeeID);
		if(employee!=null)
		{
			employee.setEmail(newEmail);
			entityManager.merge(employee);
		}		
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		Query query = entityManager.createQuery(" FROM com.pk.model.Employee");
		List<Employee> EmpList = query.getResultList();
		return EmpList;
	}	
}
