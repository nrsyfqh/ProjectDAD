package com.gov.hospital.dad.management.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {

    // Appointment ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentID")
    private int appointmentID;
    
    // Patient associated with the appointment
    @ManyToOne
    @JoinColumn(name = "patientID", referencedColumnName = "patientID")
    private Patient patient;
    
    // Department associated with the appointment
    @ManyToOne
    @JoinColumn(name = "departmentID", referencedColumnName = "departmentID")
    private Department department;
    
    // Appointment date
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @Column(name = "dateTime")
    private LocalDateTime dateTime;
    
    // Waiting number for the appointment
    @Column(name = "waitingNumber")
    private int waitingNumber;
    
    public Appointment() {
        // Default constructor
    }
	
	// Constructor with departmentID parameter
	public Appointment(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }
	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public int getWaitingNumber() {
		return waitingNumber;
	}

	public void setWaitingNumber(int waitingNumber) {
		this.waitingNumber = waitingNumber;
	}

    // Getter and setter methods for the Appointment class

    
}
