package com.aditya.employeepayrollapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aditya.employeepayrollapp.model.Employee;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<Employee, Long> {

}
