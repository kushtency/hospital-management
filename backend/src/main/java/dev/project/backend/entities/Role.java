package dev.project.backend.entities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public enum Role {
    ROLE_PATIENT, ROLE_PHYSICIAN;
    public List<SimpleGrantedAuthority> getAuthorities() {
        java.util.List<org.springframework.security.core.authority.SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority(this.name()));
        return authorities;
    }
    public String getRole(){
        return "ROLE_" + this.name().trim().toUpperCase();
    }
}
