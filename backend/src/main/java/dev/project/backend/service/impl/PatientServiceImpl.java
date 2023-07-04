package dev.project.backend.service.impl;

import java.util.List;
import java.util.Set;

import dev.project.backend.entities.Physician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.backend.entities.Patient;
import dev.project.backend.repository.PatientRepository;
import dev.project.backend.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient getRecords(Long patientID) {
		return patientRepository.findById(patientID).orElse(null);
	}

	@Override
	public List<Physician> getPhysicianList(Long patientID) {
		Patient p = patientRepository.findById(patientID).orElse(null);
		assert p != null;
		return p.getListPhysician().stream().toList();
	}

}
