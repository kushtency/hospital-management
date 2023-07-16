package dev.project.backend.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.backend.entities.Patient;
import dev.project.backend.entities.Physician;
import dev.project.backend.repository.PatientRepository;
import dev.project.backend.repository.PhysicianRepository;
import dev.project.backend.service.PhysicianService;

@Service
public class PhysicianServiceImpl implements PhysicianService{
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private PhysicianRepository physicianRepository;

	public void addPatient(Patient patient, Long physicianID) {
		Physician physician = physicianRepository.findById(physicianID).orElse(null);
		assert physician != null;
		physician.addPatientInList(patient);
		patient.addPhysicianInList(physician);
		physicianRepository.save(physician);
		patientRepository.save(patient);
	}

	@Override
	public Physician getRecord(Long physicianID) {
		return physicianRepository.findById(physicianID).orElse(null);
	}

	@Override
	public List<Physician> getPhysicianBySpeciality(String speciality) {
		return physicianRepository.findBySpeciality(speciality);
	}

	@Override
	public List<String> getSpeciality() {
		return physicianRepository.getAllSpeciality();
	}
	
	
}
