package dev.project.backend.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;


@Entity
public class PatientRecord {

	@Id
	@GeneratedValue(generator = "rec_seq")
	@SequenceGenerator(name = "rec_seq", initialValue = 1, allocationSize = 1)
	private int record_id;
	@OneToMany
	private List<Vital> vitalList;
	@OneToMany
	private List<Medication> medicationList;
	@OneToMany
	private List<Problems> problemsList;

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
