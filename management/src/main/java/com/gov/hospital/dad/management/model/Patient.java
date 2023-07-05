package com.gov.hospital.dad.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@Column(name = "patientID")
	private String patientID; // Identification No./ IC
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "emergencyContact")
	private String emergencyContact;

	public Patient() {
		// Default constructor
	}
	
	// Constructor with patientID parameter
	public Patient(String patientID) {
		this.patientID = patientID;
	}

	// Getter and setter methods for all the fields

	// Getter and setter for patientID
	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	// Getter and setter for name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Getter and setter for gender
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// Getter and setter for phoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// Getter and setter for emergencyContact
	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
}
