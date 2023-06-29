package dev.project.backend.dto;

import dev.project.backend.entities.Patient;
import dev.project.backend.entities.Physician;
import dev.project.backend.entities.User;

public class CombinedInfo {
    private User user;
    private Patient patient;
    private Physician physician;

    public CombinedInfo(User user, Patient patient, Physician physician) {
        this.user = user;
        this.patient = patient;
        this.physician = physician;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    @Override
    public String toString() {
        return "CombinedInfo{" +
                "user=" + user +
                ", patient=" + patient +
                ", physician=" + physician +
                '}';
    }
}
