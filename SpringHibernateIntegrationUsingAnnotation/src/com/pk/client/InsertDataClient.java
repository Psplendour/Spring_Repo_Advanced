package com.pk.client;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.model.Employee;
import com.pk.service.EmployeeService;
public class InsertDataClient {
       
	    public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		EmployeeService employeeService = context.getBean("employeeService",EmployeeService.class);
		context.close();
		
		createEmployee(employeeService);
		}
            private static void createEmployee(EmployeeService employeeService) {
			Employee employee= new Employee();
			employee.setEmployeeID(106);
			employee.setEmployeeName("PQR");
			employee.setEmail("PQR@gmail.com");
			employee.setSalary(1700);
			employee.setGender("male");
			employeeService.addEmployee(employee);
		}
}
  