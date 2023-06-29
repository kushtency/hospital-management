package dev.project.backend.entities;

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
