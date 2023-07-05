package com.gov.hospital.dad.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gov.hospital.dad.management.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}

/**
 * Repository interface for managing appointments in the database.
 * Extends the JpaRepository interface, providing CRUD operations and other common data access methods.
 * The entity type is Appointment, and the primary key type is Long.
 */