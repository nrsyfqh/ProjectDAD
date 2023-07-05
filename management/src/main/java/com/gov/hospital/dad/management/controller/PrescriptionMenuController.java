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

import com.gov.hospital.dad.management.model.Prescription;

@Controller
public class PrescriptionMenuController {

	private String defaultURI = "http://localhost:8080/dad/api/prescription";
	
	
	@GetMapping("/prescription/list")
	public String getPrescription(Model model)
	{
		// Retrieve the list of departments from the API
		
		String uri = "http://localhost:8080/dad/api/prescription";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Prescription[]>response =
				restTemplate.getForEntity(uri, Prescription[].class);
		Prescription prescription[] = response.getBody();
		List<Prescription>prescriptionList = Arrays.asList(prescription);
		model.addAttribute("prescription",prescriptionList);
		return "prescription";
		
	}
	
	
	@RequestMapping("prescription/save")
	public String updatePrescription (@ModelAttribute Prescription prescription) {
		RestTemplate restTemplate = new RestTemplate();
		
		// Update or save the department by making a PUT or POST request to the API
		HttpEntity <Prescription>request = new HttpEntity <Prescription>(prescription);
		String prescriptionResponse = "";
		
		if (prescription.getPrescriptionID()>0) {
			restTemplate.put(defaultURI, request,Prescription.class);
			
		}else {
			prescriptionResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(prescriptionResponse);
		return "redirect:/prescription/list";
	}
	
	
	
	@GetMapping("/prescription/{prescriptionID}")
	public String getPrescription(@PathVariable Integer prescriptionID, Model model) {
		// Retrieve a specific department by its ID and display it for editing
		String pageTitle = "New Presscription";
		Prescription prescription = new Prescription();
		if (prescriptionID > 0) {
			String uri = defaultURI + "/" + prescriptionID;
			RestTemplate restTemplate = new RestTemplate();
			prescription = restTemplate.getForObject(uri, Prescription.class);
			pageTitle ="Edit Prescription";
			
		}
		model.addAttribute("prescription",prescription);
		model.addAttribute("pageTitle",pageTitle);
		return "prescriptioninfo";
	}
	
	
	@RequestMapping("/prescription/delete/{prescriptionID}")
	public String deletePrescription(@PathVariable Integer prescriptionID) {
		// Delete a department by its ID using a DELETE request to the API
		String uri = defaultURI + "/{prescriptionID}";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri,
				Map.of("prescriptionID", Integer.toString(prescriptionID)));
		return "redirect:/prescription/list";
	}
}
