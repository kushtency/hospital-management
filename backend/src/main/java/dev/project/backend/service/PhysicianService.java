package dev.project.backend.service;

import dev.project.backend.entities.Patient;

public interface PhysicianService {

	void addPatient(Patient patient, Long physicianID);

}
