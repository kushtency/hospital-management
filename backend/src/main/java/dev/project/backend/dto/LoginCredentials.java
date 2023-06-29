package dev.project.backend.dto;

public class LoginCredentials {
    private String emailID;
    private String password;

    public LoginCredentials() {}

    public LoginCredentials(String emailID, String password) {
        this.emailID = emailID;
        this.password = password;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginCredentials{" +
                "emailID='" + emailID + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
