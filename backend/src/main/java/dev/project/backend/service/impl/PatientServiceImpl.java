package dev.project.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.project.backend.entities.Patient;
import dev.project.backend.entities.PatientRecord;
import dev.project.backend.repository.PatientRepository;
import dev.project.backend.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	
	@Autowired
	private PatientRepository patientRepository;
	
	public Patient getRecords(Long patientID) {
		return patientRepository.findById(patientID).orElse(null);
	}

}
