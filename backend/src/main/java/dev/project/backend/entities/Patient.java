package dev.project.backend.entities;

import java.util.List;

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
    
    @ManyToMany
    @JoinColumn(name = "physician_id")
    List<Physician> listPhysician;
    
//    public List<Physician> getListPhysician() {
//		return listPhysician;
//	}
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
}
