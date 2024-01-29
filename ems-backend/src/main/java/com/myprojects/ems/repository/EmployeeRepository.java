package com.myprojects.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
