package com.gov.hospital.dad.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gov.hospital.dad.management.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
/**
 * Repository interface for managing departments in the database.
 * Extends the JpaRepository interface, providing CRUD operations and other common data access methods.
 * The entity type is Department, and the primary key type is Long.
 */
