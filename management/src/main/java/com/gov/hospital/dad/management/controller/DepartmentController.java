
package com.gov.hospital.dad.management.controller;


import java.util.List;

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

import com.gov.hospital.dad.management.model.Department;
import com.gov.hospital.dad.management.repository.DepartmentRepository;


@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping
	public List<Department> getDepartment(){
		// Retrieves and returns all departments from the repository.
		return departmentRepository.findAll();
	}
	
	@GetMapping("{departmentID}")
	public Department getdepartment (@PathVariable long departmentID) {
		
		// Retrieves and returns a specific department by its ID.
		Department department= departmentRepository.findById(departmentID).get();
		return department;
	}
	
	@PostMapping()
	public Department insertDepartment(@RequestBody Department department) {
		// Inserts a new department into the repository.
		return departmentRepository.save(department);
	}

	
	@PutMapping()
	public Department updateDepartment(@RequestBody Department department) {
		// Updates an existing department in the repository.
		return departmentRepository.save(department);
	}
		
	
	@DeleteMapping("{departmentID}")
	public ResponseEntity<HttpStatus>deleteDepartmentEntity(@PathVariable long departmentID){
		// Deletes a department from the repository by its ID.
		departmentRepository.deleteById(departmentID);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}



