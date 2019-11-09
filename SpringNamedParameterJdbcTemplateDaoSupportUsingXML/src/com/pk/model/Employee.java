package com.pk.model;
public class Employee {
         private int employeeID;
         private String employeeName;
         private String email;
         private double salary;
         private String gender;
         public int getEmployeeID() {
			return employeeID;
		}
		public void setEmployeeID(int employeeID) {
			this.employeeID = employeeID;
		}
		public String getEmployeeName() {
			return employeeName;
		}
		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
}
