package com.aditya.employeepayrollapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.employeepayrollapp.DTO.EmployeePayrollDTO;
import com.aditya.employeepayrollapp.exception.EmployeeException;
import com.aditya.employeepayrollapp.model.Employee;
import com.aditya.employeepayrollapp.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@GetMapping
	public String demo() {
		return "Hello World";
	}

	@GetMapping("/get/{empId}")
	public Employee getEmployeeDetails(@PathVariable long empId) throws EmployeeException {
		return employeePayrollService.getEmployeeData(empId);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List employeesList = employeePayrollService.getAllEmployeeData();
		return new ResponseEntity<>(employeesList, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		employeePayrollService.addEmployeePayrollData(employeePayrollDTO);
		return new ResponseEntity<String>("Added EmployeePayroll Data", HttpStatus.CREATED);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO,
			@PathVariable long empId) throws EmployeeException {
		employeePayrollService.updateEmployeeById(empId, employeePayrollDTO);
		return new ResponseEntity<String>("Employee updated", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@RequestBody EmployeePayrollDTO employeePayrollDTO,
			@PathVariable long empId) throws EmployeeException {
		employeePayrollService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
	}
}
