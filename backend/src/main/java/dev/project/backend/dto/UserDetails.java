package dev.project.backend.dto;

public class UserDetails {
    private String name;
    private String emailID;
    private String sex;
    private String role;

    public UserDetails() {}

    public UserDetails(String name, String emailID, String sex, String role) {
        this.name = name;
        this.emailID = emailID;
        this.sex = sex;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
