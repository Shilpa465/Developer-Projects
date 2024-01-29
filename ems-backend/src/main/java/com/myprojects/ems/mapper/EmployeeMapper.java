package com.myprojects.ems.mapper;

import com.myprojects.ems.dto.EmployeeDTO;
import com.myprojects.ems.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
		return new EmployeeDTO(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()		
			);
	}
	
	public static Employee mapToEmployee(EmployeeDTO emplpoyeeDTO) {
		return new Employee(
				emplpoyeeDTO.getId(),
				emplpoyeeDTO.getFirstName(),
				emplpoyeeDTO.getLastName(),
				emplpoyeeDTO.getEmail()
				);
	}
}
