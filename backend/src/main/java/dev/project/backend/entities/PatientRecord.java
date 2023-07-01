package dev.project.backend.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="patient_record")
public class PatientRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int record_id;
	@OneToMany
	private List<Vital> vitalList;
	@OneToMany
	private List<Medication> medicationList;
	@OneToMany
	private List<Problems> problemsList;
	@OneToOne
	private Physician physician;
	
	
	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public int getRecord_id() {
		return record_id;
	}

	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}

	public List<Vital> getVitalList() {
		return vitalList;
	}

	public void setVitalList(List<Vital> vitalList) {
		this.vitalList = vitalList;
	}

	public List<Medication> getMedicationList() {
		return medicationList;
	}

	public void setMedicationList(List<Medication> medicationList) {
		this.medicationList = medicationList;
	}

	public List<Problems> getProblemsList() {
		return problemsList;
	}

	public void setProblemsList(List<Problems> problemsList) {
		this.problemsList = problemsList;
	}

}
