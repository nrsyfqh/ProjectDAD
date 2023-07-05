package com.gov.hospital.dad.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gov.hospital.dad.management.model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
	
	List<Doctor> findByNameContaining(String name);

}

/**
 * Repository interface for managing doctors in the database.
 * Extends the JpaRepository interface, providing CRUD operations and other common data access methods.
 * The entity type is Doctor, and the primary key type is String.
 */
