package com.gov.hospital.dad.management.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.gov.hospital.dad.management.model.Department;

@Controller
public class DepartmentMenuController {

	private String defaultURI = "http://localhost:8080/dad/api/department";
	
	
	@GetMapping("/department/list")
	public String getDepartment(Model model)
	{
		// Retrieve the list of departments from the API
		
		String uri = "http://localhost:8080/dad/api/department";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Department[]>response =
				restTemplate.getForEntity(uri, Department[].class);
		Department department[] = response.getBody();
		List<Department>departmentList = Arrays.asList(department);
		model.addAttribute("department",departmentList);
		return "department";
		
	}
	
	
	@RequestMapping("department/save")
	public String updateDepartment (@ModelAttribute Department department) {
		RestTemplate restTemplate = new RestTemplate();
		
		// Update or save the department by making a PUT or POST request to the API
		HttpEntity <Department>request = new HttpEntity <Department>(department);
		String departmentResponse = "";
		
		if (department.getDepartmentID()>0) {
			restTemplate.put(defaultURI, request,Department.class);
			
		}else {
			departmentResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(departmentResponse);
		return "redirect:/department/list";
	}
	
	
	
	@GetMapping("/department/{departmentID}")
	public String getDepartment(@PathVariable Integer departmentID, Model model) {
		// Retrieve a specific department by its ID and display it for editing
		String pageTitle = "New Department";
		Department department = new Department();
		if (departmentID > 0) {
			String uri = defaultURI + "/" + departmentID;
			RestTemplate restTemplate = new RestTemplate();
			department = restTemplate.getForObject(uri, Department.class);
			pageTitle ="Edit Order Type";
			
		}
		model.addAttribute("department",department);
		model.addAttribute("pageTitle",pageTitle);
		return "departmentinfo";
	}
	
	
	@RequestMapping("/department/delete/{departmentID}")
	public String deleteDepartment(@PathVariable Integer departmentID) {
		// Delete a department by its ID using a DELETE request to the API
		String uri = defaultURI + "/{departmentID}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("departmentID", Integer.toString(departmentID)));
		return "redirect:/department/list";
	}
}
