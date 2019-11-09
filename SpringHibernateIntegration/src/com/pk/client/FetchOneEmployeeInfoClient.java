package com.pk.client;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.pk.model.Employee;
import com.pk.service.EmployeeService;
public class FetchOneEmployeeInfoClient {
	     public static void main(String[] args) {
		 AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		 EmployeeService employeeService = context.getBean("employeeService",EmployeeService.class);
		 Employee employee = employeeService.fetchEmployeeID(106);
		 System.out.println(employee.getEmployeeID()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmail()+"\t"+employee.getGender()+"\t"+employee.getSalary());
		 
		 context.close();
		 }
}
  