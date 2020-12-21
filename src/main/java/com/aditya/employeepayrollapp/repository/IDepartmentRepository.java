package com.aditya.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.employeepayrollapp.model.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {

}
