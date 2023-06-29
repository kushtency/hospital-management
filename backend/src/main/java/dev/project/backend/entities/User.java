package dev.project.backend.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    @Column(name = "email")
    private String emailID;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name ="sex")
    private String sex;
    @Column(name = "age")
    private int age;
    @Enumerated(EnumType.STRING)
    private Role role;

    // mapping
    @OneToOne(mappedBy = "userPatient", cascade = CascadeType.ALL)
    private Patient patient;

    @OneToOne(mappedBy = "userPhysician", cascade = CascadeType.ALL)
    private Physician physician;

    public User() {}

    public User(String emailID, String name, String password, String sex, String role, int age) {
        this.emailID = emailID;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.role = Role.valueOf(role);
        this.age = age;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return this.role.name();
    }

    public void setRole(String role) {
        this.role = Role.valueOf("ROLE_"+role.trim().toUpperCase());
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.emailID;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", emailID='" + emailID + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", role=" + role +
                '}';
    }
}
