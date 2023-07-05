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

import com.gov.hospital.dad.management.model.Prescription;
import com.gov.hospital.dad.management.repository.PrescriptionRepository;

@RestController
@RequestMapping("/api/prescription")
public class PrescriptionRESTController {
		
		@Autowired
		private PrescriptionRepository prescriptionRepository;
		
		@GetMapping
		public List <Prescription> getPrescription(){
			return prescriptionRepository.findAll();
		}
		
		@GetMapping("{prescriptionID}")
		public Prescription getPrescription (@PathVariable long prescriptionID) {
			Prescription prescription = prescriptionRepository.findById(prescriptionID).get();
			return prescription;
		}
		
		@PostMapping()
		public Prescription insertPrescription(@RequestBody Prescription prescription) {
			return prescriptionRepository.save(prescription);
		}
		
		@PutMapping()
		public Prescription updatePrescription (@RequestBody Prescription prescription) {
			return prescriptionRepository.save(prescription);
		}
		
		@DeleteMapping("{prescriptionID}")
		public ResponseEntity<HttpStatus>deletePrescriptionEntity(@PathVariable long prescriptionID) {
			prescriptionRepository.deleteById(prescriptionID);
			return new ResponseEntity<>(HttpStatus.OK);
		}

}
