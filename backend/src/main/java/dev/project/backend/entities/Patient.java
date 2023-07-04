package dev.project.backend.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientID;
    @Column(name = "complaint")
    private String complaint;
    
    
    //patient crud
    //bmi crud
    //medication crud
    //problem crud
    //vital crud
    //patient link with doctor
    
    
    // mapping
    @OneToOne
    @JoinColumn(name = "user_id")
    User userPatient;
    
    @OneToMany(mappedBy = "recordForPatient", cascade = CascadeType.ALL)
    private List<PatientRecord> patientRecords;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Set<Physician> listPhysician = new HashSet<>();
    
    public Set<Physician> getListPhysician() {
		return listPhysician;
	}
//
//	public void setListPhysician(List<Physician> listPhysician) {
//		this.listPhysician = listPhysician;
//	}

	public List<PatientRecord> getPatientRecords() {
		return patientRecords;
	}

	public void setPatientRecords(List<PatientRecord> patientRecords) {
		this.patientRecords = patientRecords;
	}

	public Patient() {}
	
    @Override
	public String toString() {
		return "Patient [patientID=" + patientID + ", complaint=" + complaint + ", userPatient=" + userPatient
				+ ", patientRecords=" + patientRecords + ", listPhysician=" + listPhysician + "]";
	}

	public Patient(String complaint) {
        this.complaint = complaint;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setUser(User userPatient) {
        this.userPatient = userPatient;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public void addPhysicianInList(Physician physician){ this.listPhysician.add(physician); }
}
