package com.myprojects.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myprojects.ems.dto.EmployeeDTO;
import com.myprojects.ems.entity.Employee;
import com.myprojects.ems.exception.ResourceNotFoundException;
import com.myprojects.ems.mapper.EmployeeMapper;
import com.myprojects.ems.repository.EmployeeRepository;
import com.myprojects.ems.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		
//		 System.out.println(employeeDTO.getId());  
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee savedEmployee = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
	}

	@Override
	public EmployeeDTO getEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId)
		.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist for the given id:" + employeeId));
		
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		
		
		List<Employee> allEmployees = employeeRepository.findAll();
		
		return allEmployees.stream().map((employee)->EmployeeMapper.mapToEmployeeDTO(employee))
		.collect(Collectors.toList());
		
	
	}

	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployeeDTO) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for the given id:" + employeeId));
		
		employee.setFirstName(updatedEmployeeDTO.getFirstName());
		employee.setLastName(updatedEmployeeDTO.getLastName());
		employee.setEmail(updatedEmployeeDTO.getEmail());
		
		employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee does not exist for the given id:" + employeeId));
		
		employeeRepository.delete(employee);
		
	}
	

	
}
