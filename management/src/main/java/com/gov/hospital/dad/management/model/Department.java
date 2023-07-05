package com.gov.hospital.dad.management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

	// Department ID
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "departmentID")
	private int departmentID;
	
	 // Department name
	@Column(name = "name")
	private String name;
	
	 // Department phone number
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	
	public Department() {
        // Default constructor
    }
	
	// Constructor with departmentID parameter
	public Department(int departmentID) {
        this.departmentID = departmentID;
    }
	
	 // Getter and setter methods for department

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
