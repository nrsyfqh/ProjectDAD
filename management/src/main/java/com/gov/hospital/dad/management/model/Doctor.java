package com.gov.hospital.dad.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@Column(name = "doctorID")
	private String doctorID; // Identification No./ IC
	
	@ManyToOne
	@JoinColumn(name = "departmentID")
	private Department department; // Foreign key relationship to the Department entity
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;

	// Getter and setter methods for all the fields

	public Doctor() {
        // Default constructor
    }
	
	// Constructor with departmentID parameter
	public Doctor(String doctorID) {
        this.doctorID = doctorID;
    }
	// Getter and setter for doctorID
	
	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	// Getter and setter for department
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// Getter and setter for name
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Getter and setter for phoneNumber
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// Getter and setter for email
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
