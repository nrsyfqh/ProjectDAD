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

import com.gov.hospital.dad.management.model.Patient;
import com.gov.hospital.dad.management.repository.PatientRepository;

@RestController
@RequestMapping("/api/patient")
public class PatientRESTController {

	@Autowired
	private PatientRepository patientRepository;
	
	// GET endpoint to retrieve all patients
	@GetMapping
	public List<Patient> getPatient(){
		return patientRepository.findAll();
	}
	
	@RequestMapping("/find/name")
	public List<Patient> findPatient(@RequestBody Patient patient) {
	    // Find patients by name using the patientRepository
	    List<Patient> patients = patientRepository.findByNameContaining(patient.getName());
	    return patients;
	}

	// GET endpoint to retrieve a specific patient by ID
	@GetMapping("{patientID}")
	public Patient getPatient(@PathVariable String patientID) {
		Patient patient = patientRepository.findById(patientID).get();
		return patient;
	}
	
	// POST endpoint to insert a new patient
	@PostMapping()
	public Patient insertPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	// PUT endpoint to update an existing patient
	@PutMapping()
	public Patient updatePatient(@RequestBody Patient patient ) {
		return patientRepository.save(patient);
	}
	
	// DELETE endpoint to delete a patient by ID
	@DeleteMapping("{patientID}")
	public ResponseEntity<HttpStatus> deletePatientEntity(@PathVariable String patientID){
		patientRepository.deleteById(patientID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
