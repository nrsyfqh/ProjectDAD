package com.gov.hospital.dad.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gov.hospital.dad.management.model.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}
/**
 * Repository interface for managing prescriptions in the database.
 * Extends the JpaRepository interface, providing CRUD operations and other common data access methods.
 * The entity type is Prescription, and the primary key type is Long.
 */
