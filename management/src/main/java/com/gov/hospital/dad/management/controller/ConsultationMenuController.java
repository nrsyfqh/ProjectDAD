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

import com.gov.hospital.dad.management.model.Consultation;

@Controller
public class ConsultationMenuController {

    private String defaultURI = "http://localhost:8080/dad/api/consultation";

    // Get list of consultations
    @GetMapping("/consultation/list")
    public String getConsultation(Model model) {
        String uri = "http://localhost:8080/dad/api/consultation";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Consultation[]> response = restTemplate.getForEntity(uri, Consultation[].class);
        Consultation[] consultation = response.getBody();
        List<Consultation> consultationList = Arrays.asList(consultation);
        model.addAttribute("consultation", consultationList);
        return "consultation";
    }

    // Save/update a consultation
    @RequestMapping("consultation/save")
    public String updateConsultation(@ModelAttribute Consultation consultation) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Consultation> request = new HttpEntity<Consultation>(consultation);
        String consultationResponse = "";

        if (consultation.getConsultationID() > 0) {
            // If consultation ID is present, perform an update
            restTemplate.put(defaultURI, request, Consultation.class);
        } else {
            // If consultation ID is not present, perform a save
            consultationResponse = restTemplate.postForObject(defaultURI, request, String.class);
        }
        System.out.println(consultationResponse);
        return "redirect:/consultation/list";
    }

    // Get a single consultation for editing
    @GetMapping("/consultation/{consultationID}")
    public String getConsultation(@PathVariable Integer consultationID, Model model) {
        String pageTitle = "New Consultation";
        Consultation consultation = new Consultation();
        if (consultationID > 0) {
            // If consultation ID is present, retrieve the consultation for editing
            String uri = defaultURI + "/" + consultationID;
            RestTemplate restTemplate = new RestTemplate();
            consultation = restTemplate.getForObject(uri, Consultation.class);
            pageTitle = "Edit Consultation";
        }
        model.addAttribute("consultation", consultation);
        model.addAttribute("pageTitle", pageTitle);
        return "consultationinfo";
    }

    // Delete a consultation
    @RequestMapping("/consultation/delete/{consultationID}")
    public String deleteConsultation(@PathVariable("consultationID") Long consultationID) {
        String uri = defaultURI + "/{consultationID}";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri, consultationID);
        return "redirect:/consultation/list";
    }
}
