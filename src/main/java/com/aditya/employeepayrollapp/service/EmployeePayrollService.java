package com.aditya.employeepayrollapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
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

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Employee addEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		Employee emp = new Employee(employeePayrollDTO);
		modelMapper.map(employeePayrollDTO, emp);
		return employeePayrollRepo.save(emp);
	}

	@Override
	public Employee getEmployeeData(long empId) throws EmployeeException {
		return employeePayrollRepo.findById(empId).orElseThrow(() -> new EmployeeException("Invalid user id"));
	}

	@Override
	public List<Employee> getAllEmployeeData() {
		return employeePayrollRepo.findAll();
	}

	@Override
	public Employee updateEmployeeById(long empId, EmployeePayrollDTO employeePayrollDTO) throws EmployeeException {
		Employee emp = getEmployeeData(empId);
		modelMapper.map(employeePayrollDTO, emp);
		return employeePayrollRepo.save(getEmployeeData(empId));
	}

	@Override
	public String deleteEmployeeById(long empId) throws EmployeeException {
		Employee emp = getEmployeeData(empId);
		employeePayrollRepo.deleteById(empId);
		return "This user is deleted";
	}
	
	@Override
	public Employee getEmployeeData(String emailId) throws EmployeeException {
		return employeePayrollRepo.findByEmailId(emailId).orElseThrow(() -> new EmployeeException("Invalid user id"));
	}

}
