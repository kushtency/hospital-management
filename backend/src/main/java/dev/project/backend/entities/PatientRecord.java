package dev.project.backend.entities;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name="patient_record")
public class PatientRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "record_id")
	private int recordID;
	@OneToMany(mappedBy = "vitalRecord", cascade = CascadeType.ALL)
	private List<Vital> vitalList;
	@OneToMany(mappedBy = "medicationRecord", cascade = CascadeType.ALL)
	private List<Medication> medicationList;
	@OneToMany(mappedBy = "problemRecord", cascade = CascadeType.ALL)
	private List<Problems> problemsList;
	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient recordForPatient;


	public Patient getPatient() {
		return recordForPatient;
	}
	public void setPatient(Patient recordForPatient) {
		this.recordForPatient = recordForPatient;
	}
	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
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
