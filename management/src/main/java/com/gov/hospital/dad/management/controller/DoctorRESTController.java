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

import com.gov.hospital.dad.management.model.Doctor;
import com.gov.hospital.dad.management.repository.DoctorRepository;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRESTController {

	@Autowired
	private DoctorRepository doctorRepository;
	
	// GET endpoint to retrieve all doctors
	@GetMapping
	public List<Doctor> getDoctor(){
		return doctorRepository.findAll();
	}
	
	// GET endpoint to retrieve a specific doctor by ID
	@GetMapping("{doctorID}")
	public Doctor getDoctor(@PathVariable String doctorID) {
		Doctor doctor = doctorRepository.findById(doctorID).get();
		return doctor;
	}
	
	// POST endpoint to insert a new doctor
	@PostMapping()
	public Doctor insertdoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	// PUT endpoint to update an existing doctor
	@PutMapping()
	public Doctor updatedoctor(@RequestBody Doctor doctor ) {
		return doctorRepository.save(doctor);
	}
	
	// DELETE endpoint to delete a doctor by ID
	@DeleteMapping("{doctorID}")
	public ResponseEntity<HttpStatus> deleteDoctorEntity(@PathVariable String doctorID){
		doctorRepository.deleteById(doctorID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
