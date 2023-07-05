package com.gov.hospital.dad.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gov.hospital.dad.management.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

	List<Patient> findByNameContaining(String name);
}
/**
 * Repository interface for managing patients in the database.
 * Extends the JpaRepository interface, providing CRUD operations and other common data access methods.
 * The entity type is Patient, and the primary key type is String.
 * Provides a custom method to find patients whose names contain a specific keyword.
 */
