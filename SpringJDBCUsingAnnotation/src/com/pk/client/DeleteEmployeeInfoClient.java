package com.pk.client;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pk.service.EmployeeService;
public class DeleteEmployeeInfoClient {

	    public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		EmployeeService employeeService = context.getBean("employeeService",EmployeeService.class);
	    employeeService.deleteEmployeeById(101);
		 context.close();;
	    }
}
  