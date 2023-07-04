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

//		System.out.println("Patient is  : "+ patient);
		assert physician != null;
		physician.addPatientInList(patient);
		patient.addPhysicianInList(physician);
//		System.out.println("Physician is : "+ physician);
		physicianRepository.save(physician);
		patientRepository.save(patient);
//		System.out.println(patient);
//		List<Patient> listPatient = physician.getListPatient();
//		listPatient.add(patient);
//		physician.setListPatient(listPatient);
//		physicianRepository.save(physician);
//		System.out.println(physician);
		
		
//		List<Physician> listPhysicians = patient.getListPhysician();
//		listPhysicians.add(physician);
//		patient.setListPhysician(listPhysicians);
//		System.out.println(patient);
		Set<Patient> p = physician.getListPatient();
//		System.out.println(physician.getListPatient());
		
//		for(Patient pt:physician.getListPatient()) {
//			System.out.println(pt);
//		}
		
	}

	
	
}
