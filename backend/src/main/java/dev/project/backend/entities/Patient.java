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
    
    
    // mapping
    @OneToOne
    @JoinColumn(name = "user_id")
    User userPatient;
    
    @OneToMany(mappedBy = "recordForPatient", cascade = CascadeType.ALL)
    private List<PatientRecord> patientRecords;
    
    @ManyToMany
    @JoinColumn(name = "physician_id")
    List<Physician> listPhysician;
    
    public List<PatientRecord> getPatientRecords() {
		return patientRecords;
	}

	public void setPatientRecords(List<PatientRecord> patientRecords) {
		this.patientRecords = patientRecords;
	}

	public Patient() {}

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
