package dev.project.backend.repository;

import dev.project.backend.entities.Patient;
import dev.project.backend.entities.Physician;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhysicianRepository extends JpaRepository<Physician, Long> {

}
