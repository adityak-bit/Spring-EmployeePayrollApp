package com.aditya.employeepayrollapp.DTO;

import java.util.List;

import javax.validation.constraints.Pattern;

import com.aditya.employeepayrollapp.model.Department;
import com.aditya.employeepayrollapp.model.Employee;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
//	@Size(max = 10, min = 3, message = "Name length should be between 3-10." )
//	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,9}$" , message = "Invalid name")
//	public String name;
//	@Min(value = 9, message = "Salary digit should be greater than 1")
//	public long salary;
//	public String gender;
//	
//	public EmployeePayrollDTO(String name, long salary) {
//		this.name=name;
//		this.salary=salary;
//	}

	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}", message = "Invalid name")
	private String name;
	private String profile;
	private String gender;
	private List<Department> department;
	private String salary;
	private String startDate;
	private String notes;

	public EmployeePayrollDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}