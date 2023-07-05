package com.gov.hospital.dad.management.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consulatationnote")
public class Consultation {

	 // Consultation ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consultationID")
	private int consultationID;

	// Appointment associated with the consultation
	@ManyToOne
	@JoinColumn(name = "appointmentID")
	private Appointment appointment;

    // Doctor associated with the consultation
	@ManyToOne
	@JoinColumn(name = "doctorID")
	private Doctor doctor;

	// Description of the consultation
	@Column(name = "description")
	private String description;

	 // Timestamp of when the consultation was recorded
	@Column(name = "recordedOn")
	private LocalDateTime recordedOn;


	// Name of the person who recorded the consultation
	@Column(name = "recordedBy")
	private String recordedBy;
	

	public Consultation() {
        // Default constructor
    }
	
	// Constructor with departmentID parameter
	public Consultation(int consultationID) {
        this.consultationID = consultationID;
    }
	
	 // Getter and setter methods for the Consultation 
	public int getConsultationID() {
		return consultationID;
	}

	public void setConsultationID(int consultationID) {
		this.consultationID = consultationID;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getRecordedOn() {
		return recordedOn;
	}

	public void setRecordedOn(LocalDateTime recordedOn) {
		this.recordedOn = recordedOn;
	}

	public String getRecordedBy() {
		return recordedBy;
	}

	public void setRecordedBy(String recordedBy) {
		this.recordedBy = recordedBy;
	}
}
