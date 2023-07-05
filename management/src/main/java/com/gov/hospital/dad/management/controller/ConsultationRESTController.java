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

import com.gov.hospital.dad.management.model.Consultation;
import com.gov.hospital.dad.management.repository.ConsultationRepository;

@RestController
@RequestMapping("/api/consultation")

public class ConsultationRESTController {
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	@GetMapping
	public List <Consultation> getConsultation(){
		// Retrieves and returns all consultations from the repository.
		return consultationRepository.findAll();
	}
	
	@GetMapping("{consultationID}")
	public Consultation getConsultation(@PathVariable long consultationID) {
		// Retrieves and returns a specific consultation by its ID
		Consultation consultation= consultationRepository.findById(consultationID).get();
		return consultation;
	}
	
	@PostMapping()
	public Consultation insertConsultation(@RequestBody Consultation consultation) {
		// Inserts a new consultation into the repository.
		return consultationRepository.save(consultation);
	}
	
	@PutMapping()
	public Consultation updateConsultation(@RequestBody Consultation consultation) {
		// Updates an existing consultation in the repository.
		return consultationRepository.save(consultation);
	}
	
	@DeleteMapping("{consultationID}")
	public ResponseEntity<HttpStatus>deleteConsultationEntity(@PathVariable long consultationID){
		// Deletes a consultation from the repository by its ID.
		consultationRepository.deleteById(consultationID);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
