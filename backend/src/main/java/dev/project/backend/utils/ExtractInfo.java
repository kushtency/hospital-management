package dev.project.backend.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ExtractInfo {
    private PasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public String getEncodedPassword(String password){
        return encoder.encode(password.trim());
    }
    public String getExactRole(String role) {
        String r = "ROLE_" +  role.trim().toUpperCase();
        System.out.println(r);
        return r;
    }
}
