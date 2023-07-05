package com.gov.hospital.dad.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gov.hospital.dad.management.model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
/**
 * Repository interface for managing consultations in the database.
 * Extends the JpaRepository interface, providing CRUD operations and other common data access methods.
 * The entity type is Consultation, and the primary key type is Long.
 */