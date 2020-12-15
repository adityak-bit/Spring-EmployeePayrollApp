package com.aditya.employeepayrollapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.aditya.employeepayrollapp.exception.EmployeeException;
import com.aditya.employeepayrollapp.model.Employee;
import com.aditya.employeepayrollapp.repository.IEmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private IEmployeePayrollRepository employeePayrollRepo;

	@Override
	public Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		Employee emp = new Employee(employeePayrollDTO);
		return employeePayrollRepo.save(emp);
	}

	@Override
	public Employee getEmployeeData(long empId) throws EmployeeException {
		return employeePayrollRepo.findById(empId).orElseThrow(() -> new EmployeeException("Invalid user id"));
	}

	@Override
	public void updateEmployeeById(long empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException {
		Employee emp = getEmployeeData(empId);
		if (employeePayrollDTO.name != null) {
			emp.setName(employeePayrollDTO.name);
		}
		if (employeePayrollDTO.salary != 0.0) {
			emp.setSalary(employeePayrollDTO.salary);
		}
		employeePayrollRepo.save(emp);
	}

	@Override
	public void deleteEmployeeById(long empId) throws EmployeeException {
		employeePayrollRepo.deleteById(empId);
	}
	
	@Override
	public List getAllEmployeeData() {
		return employeePayrollRepo.findAll();
	} 

}
