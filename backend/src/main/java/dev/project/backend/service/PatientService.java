package dev.project.backend.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.project.backend.entities.Patient;
import dev.project.backend.entities.PatientRecord;

public interface PatientService{

	Patient getRecords(Long patientID);

}
