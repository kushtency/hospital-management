package dev.project.backend.service.impl;

import dev.project.backend.dto.CombinedInfo;
import dev.project.backend.dto.LoginCredentials;
import dev.project.backend.dto.Message;
import dev.project.backend.dto.Send;
import dev.project.backend.entities.Patient;
import dev.project.backend.entities.Physician;
import dev.project.backend.entities.Role;
import dev.project.backend.entities.User;
import dev.project.backend.repository.PatientRepository;
import dev.project.backend.repository.PhysicianRepository;
import dev.project.backend.repository.UserRepository;
import dev.project.backend.service.UserService;
import dev.project.backend.service.authentication.JwtService;
import dev.project.backend.utils.ExtractInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ExtractInfo extractInfo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PatientRepository patientRepository;
    private final PhysicianRepository physicianRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           AuthenticationManager authenticationManager,
                           JwtService jwtService,
                           PatientRepository patientRepository,
                           PhysicianRepository physicianRepository){
        this.userRepository = userRepository;
        this.extractInfo = new ExtractInfo();
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.patientRepository = patientRepository;
        this.physicianRepository = physicianRepository;
    }
    @Override
    public Message createUser(CombinedInfo user) {
        User u = user.getUser();
        try{
            User createdUser = new User(
                    u.getEmailID(),
                    u.getName(),
                    extractInfo.getEncodedPassword(u.getPassword()),
                    u.getSex(),
                    u.getRole(),
                    u.getAge());
            userRepository.save(createdUser);
            if(Objects.equals(u.getRole(), Role.ROLE_PATIENT.name())){
                Patient p = new Patient(user.getPatient().getComplaint());
                p.setUser(createdUser);
                patientRepository.save(p);
            }else{
                Physician phy = user.getPhysician();
                phy.setUserPhysician(createdUser);
                physicianRepository.save(phy);
            }
        } catch (Exception e){
            System.out.println(e);
            Send.response.set("some error occured while creating user", 0);
            return Send.response;
        }
        Send.response.set("successfully registered user", 1);
        return Send.response;
    }

    @Override
    public User getUser(String emailID) {
        return userRepository.findByUserID(emailID);
    }

    @Override
    public String loginUser(LoginCredentials loginCredentials) {
        System.out.println(loginCredentials);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginCredentials.getEmailID(), loginCredentials.getPassword())
        );
        User user = userRepository.findByUserID(loginCredentials.getEmailID());
        return jwtService.generateToken(user);
    }
}
