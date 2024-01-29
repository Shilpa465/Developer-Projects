package com.myprojects.ems.controller;

import java.util.List;

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

import com.myprojects.ems.dto.EmployeeDTO;
import com.myprojects.ems.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;
	
//	To create employees
	@PostMapping
	ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		EmployeeDTO savedEmpployeeDTO = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(savedEmpployeeDTO,HttpStatus.CREATED);
		
	}
	
//	To fetch employee details based on Employee Id
	@GetMapping("{id}")
	ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Long employeeId){
		
		EmployeeDTO savedEmpployeeDTO = employeeService.getEmployee(employeeId);
		
		return ResponseEntity.ok(savedEmpployeeDTO);
	}
	
	
//	To fetch all the existing employees
	@GetMapping
	ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		
		List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
		
		return ResponseEntity.ok(allEmployees);
		
	}
	
//	To update employees based on the Employee Id
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id")Long employeeId,@RequestBody EmployeeDTO updatedEmployee){
		
		EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployee);
		
		return ResponseEntity.ok(employeeDTO);
		
	}
	
//	To delete an employee based on Employee Id
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long employeeId){
		
		employeeService.deleteEmployee(employeeId);
		
		return ResponseEntity.ok("Employee has been successfully deleted.");
		
	}
	

}
