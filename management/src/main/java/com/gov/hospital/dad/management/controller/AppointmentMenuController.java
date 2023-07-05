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

import com.gov.hospital.dad.management.model.Appointment;

@Controller
public class AppointmentMenuController {

	private String defaultURI = "http://localhost:8080/dad/api/appointment";

	@GetMapping("/appointment/list")
	public String getAppointment(Model model)
	{
		String uri = "http://localhost:8080/dad/api/appointment";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Appointment[]>response = 
				restTemplate.getForEntity(uri, Appointment[].class);
		Appointment appointment[] = response.getBody();
		List<Appointment>appointmentList = Arrays.asList(appointment);
		model.addAttribute("appointment",appointmentList);
		return "appointment";
	}
	
	@RequestMapping("appointment/save")
	public String updateAppointment (@ModelAttribute Appointment appointment) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity <Appointment>request = new HttpEntity <Appointment>(appointment);
		String appointmentResponse = "";
		
		if (appointment.getAppointmentID()>0) {
			restTemplate.put(defaultURI, request,Appointment.class);
			
		}else {
			appointmentResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(appointmentResponse);
		return "redirect:/appointment/list";
	}
	
	@GetMapping("/appointment/{doctorID}")
    public String getAppointment(@PathVariable Integer appointmentID, Model model) {
        String pageTitle = "New Appointment";
        Appointment appointment = new Appointment();	
        if (appointmentID > 0) {
            String uri = defaultURI + "/" + appointmentID;
            RestTemplate restTemplate = new RestTemplate();
            appointment = restTemplate.getForObject(uri, Appointment.class);
            pageTitle = "Edit Appointment";
        }
		
        model.addAttribute("appointment", appointment);
        model.addAttribute("pageTitle", pageTitle);
        return "appointmentinfo";
    }
	
	@RequestMapping("/appointment/delete/{appointmentID}")
	public String deleteAppointment(@PathVariable Integer appointmentID) {
	    String uri = defaultURI + "/{appointmentID}";
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.delete(uri, Map.of("appointmentID",  Integer.toString(appointmentID)));
	    return "redirect:/appointment/list";
	}
}
