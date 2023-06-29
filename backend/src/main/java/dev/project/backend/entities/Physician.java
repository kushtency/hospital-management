package dev.project.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name="physician")
public class Physician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "physician_id")
    private Long physicianID;
    @Column(name = "title")
    private String title;
    @Column(name = "address")
    private String address;
    @Column(name = "speciality")
    private String speciality;

    // mapping
    @OneToOne
    @JoinColumn(name = "user_id")
    User userPhysician;

    public Physician() {}

    public Physician(String title, String address, String speciality) {
        this.title = title;
        this.address = address;
        this.speciality = speciality;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setUserPhysician(User userPhysician) {
        this.userPhysician = userPhysician;
    }
}
