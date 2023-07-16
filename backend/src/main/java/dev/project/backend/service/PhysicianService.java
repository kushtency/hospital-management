package dev.project.backend.service;

import java.util.List;

import dev.project.backend.entities.Patient;
import dev.project.backend.entities.Physician;

public interface PhysicianService {

	void addPatient(Patient patient, Long physicianID);

	Physician getRecord(Long physicianID);

	List<Physician> getPhysicianBySpeciality(String speciality);

	List<String> getSpeciality();

}
