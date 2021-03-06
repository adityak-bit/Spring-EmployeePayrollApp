package com.aditya.employeepayrollapp.service;

import java.util.List;

import com.aditya.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.aditya.employeepayrollapp.exception.EmployeeException;
import com.aditya.employeepayrollapp.model.Employee;

public interface IEmployeePayrollService {

	Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

	Employee getEmployeeData(long empId) throws EmployeeException;

	Employee updateEmployeeById(long empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException;

	String deleteEmployeeById(long empId) throws EmployeeException;

	List getAllEmployeeData();

	Employee getEmployeeData(String emailId) throws EmployeeException;
}
