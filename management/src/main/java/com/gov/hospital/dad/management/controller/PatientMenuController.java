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

import com.gov.hospital.dad.management.model.Patient;

@Controller
public class PatientMenuController {

	private String defaultURI = "http://localhost:8080/dad/api/patient";

	@GetMapping("/patients/list")
	public String getPatient(Model model)
	{
		String uri = "http://localhost:8080/dad/api/patient";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Patient[]>response = 
				restTemplate.getForEntity(uri, Patient[].class);
		Patient patient[] = response.getBody();
		List<Patient>patientList = Arrays.asList(patient);
		model.addAttribute("patient",patientList);
		return "patient";
	}
	
	@RequestMapping("patients/save")
	public String updatePatient (@ModelAttribute Patient patient) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <Patient>request = new HttpEntity <Patient>(patient);
		String patientResponse = "";
		
		if (patient.getPatientID() != null) {
			restTemplate.put(defaultURI, request,Patient.class);
			
		}else {
			patientResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(patientResponse);
		return "redirect:/patients/list";
	}
	
	@GetMapping("/patients/{patientID}")
    public String getPatient(@PathVariable String patientID, Model model) {
        String pageTitle = "New Patient";
        Patient patient = new Patient();
		
        if (patientID != null) {
            String uri = defaultURI + "/" + patientID;
            RestTemplate restTemplate = new RestTemplate();
            patient = restTemplate.getForObject(uri, Patient.class);
            pageTitle = "Edit Patient";
        }
		
        model.addAttribute("patient", patient);
        model.addAttribute("pageTitle", pageTitle);
        return "patientinfo";
    }
	
	@RequestMapping("/patients/delete/{patientID}")
	public String deletePatient(@PathVariable String patientID) {
	    String uri = defaultURI + "/{patientID}";
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete(uri, Map.of("patientID", patientID));
	    return "redirect:/patients/list";
	}

}
