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

import com.gov.hospital.dad.management.model.Appointment;
import com.gov.hospital.dad.management.repository.AppointmentRepository;

/**
 * 
 * @author nursy
 *
 */
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;
    
    // Retrieve appointments
    @GetMapping
    public List<Appointment> getAppointment() {
        return appointmentRepository.findAll();
    }
    
    // Retrieve a specific appointment by ID
    @GetMapping("{appointmentID}")
    public Appointment getAppointment(@PathVariable long appointmentID) {
        Appointment appointment = appointmentRepository.findById(appointmentID).get();
        return appointment;
    }
    
    // Create a new appointment
    @PostMapping
    public Appointment insertAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    
    // Update an existing appointment
    @PutMapping
    public Appointment updateAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    
    // Delete an appointment by ID
    @DeleteMapping("{appointmentID}")
    public ResponseEntity<HttpStatus> deleteAppointmentEntity(@PathVariable long
    		appointmentID) {
        appointmentRepository.deleteById(appointmentID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
