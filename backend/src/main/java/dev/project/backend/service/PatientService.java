package dev.project.backend.service;

import java.util.List;

import dev.project.backend.entities.Physician;

import dev.project.backend.entities.Patient;

public interface PatientService{

	Patient getRecords(Long patientID);

    List<Physician> getPhysicianList(Long patientID);
}
