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

import com.gov.hospital.dad.management.model.Doctor;

@Controller
public class DoctorMenuController {

	private String defaultURI = "http://localhost:8080/dad/api/doctor";

	@GetMapping("/doctors/list")
	public String getDoctor(Model model)
	{
		String uri = "http://localhost:8080/dad/api/doctor";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Doctor[]>response = 
				restTemplate.getForEntity(uri, Doctor[].class);
		Doctor doctor[] = response.getBody();
		List<Doctor>doctorList = Arrays.asList(doctor);
		model.addAttribute("doctor",doctorList);
		return "doctor";
	}
	
	@RequestMapping("doctors/save")
	public String updateDoctor (@ModelAttribute Doctor doctor) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <Doctor>request = new HttpEntity <Doctor>(doctor);
		String doctorResponse = "";
		
		if (doctor.getDoctorID() != null) {
			restTemplate.put(defaultURI, request,Doctor.class);
			
		}else {
			doctorResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(doctorResponse);
		return "redirect:/doctors/list";
	}
	
	@GetMapping("/doctors/{doctorID}")
    public String getDoctor(@PathVariable String doctorID, Model model) {
        String pageTitle = "New Doctor";
        Doctor doctor = new Doctor();
		
        if (doctorID != null) {
            String uri = defaultURI + "/" + doctorID;
            RestTemplate restTemplate = new RestTemplate();
            doctor = restTemplate.getForObject(uri, Doctor.class);
            pageTitle = "Edit Doctor";
        }
		
        model.addAttribute("doctor", doctor);
        model.addAttribute("pageTitle", pageTitle);
        return "doctorinfo";
    }
	
	@RequestMapping("/doctors/delete/{doctorID}")
	public String deleteDoctor(@PathVariable String doctorID) {
	    String uri = defaultURI + "/{doctorID}";
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete(uri, Map.of("doctorID", doctorID));
	    return "redirect:/doctors/list";
	}

}
