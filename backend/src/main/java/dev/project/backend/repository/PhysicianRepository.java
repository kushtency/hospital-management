package dev.project.backend.repository;

import dev.project.backend.entities.Patient;
import dev.project.backend.entities.Physician;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicianRepository extends JpaRepository<Physician, Long> {

	List<Physician> findBySpeciality(String speciality);

	@Query("SELECT p.speciality FROM Physician p")
	List<String> getAllSpeciality();

}
