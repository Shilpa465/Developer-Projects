package com.myprojects.ems.service;

import java.util.List;

import com.myprojects.ems.dto.EmployeeDTO;

public interface EmployeeService {

	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO getEmployee(Long employeeId);
	
	List<EmployeeDTO> getAllEmployees();
	
	EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployeeDTO);
	
	void deleteEmployee(Long employeeId);
	
}
