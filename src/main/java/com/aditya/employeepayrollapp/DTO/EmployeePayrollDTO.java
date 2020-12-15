package com.aditya.employeepayrollapp.DTO;

public class EmployeePayrollDTO {

	public String name;
	public long salary;
	
	public EmployeePayrollDTO(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public EmployeePayrollDTO() {}
}
