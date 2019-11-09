package com.pk.client;
import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.pk.model.Employee;
import com.pk.service.EmployeeService;
public class FetchAllEmployeesInfoClient {
        public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EmployeeService employeeService = context.getBean("employeeService",EmployeeService.class);
		
	     List<Employee> allEmployeeInfo = employeeService.getAllEmployeeInfo();
		 for (Employee employee : allEmployeeInfo) 
		 {
			 System.out.println(employee.getEmployeeID()+"\t"+employee.getEmployeeName()+"\t"+employee.getEmail()+"\t"+employee.getGender()+"\t"+employee.getSalary());
			 context.close();;
		 } 
	   }
}
  