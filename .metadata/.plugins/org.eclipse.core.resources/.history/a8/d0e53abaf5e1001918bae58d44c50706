package com.pk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_table")
public class Employee {
	     @Id
	     //@GeneratedValue (strategy=GenerationType.IDENTITY)
	     @Column(name="employeeID")
         private int employeeID;
	    @Column(name="employeeName")
         private String employeeName;
	     @Column(name="email")
         private String email;
	    @Column(name="salary")
         private double salary;
	    @Column(name="gender")
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
