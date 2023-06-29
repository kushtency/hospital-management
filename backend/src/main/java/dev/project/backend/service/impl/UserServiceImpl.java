package dev.project.backend.service.impl;

import dev.project.backend.dto.LoginCredentials;
import dev.project.backend.dto.Message;
import dev.project.backend.dto.Send;
import dev.project.backend.entities.User;
import dev.project.backend.repository.UserRepository;
import dev.project.backend.service.UserService;
import dev.project.backend.service.authentication.JwtService;
import dev.project.backend.utils.ExtractInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ExtractInfo extractInfo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuthenticationManager authenticationManager, JwtService jwtService){
        this.userRepository = userRepository;
        this.extractInfo = new ExtractInfo();
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }
    @Override
    public Message createUser(User user) {
        try{
            User u = new User(
                    user.getEmailID(),
                    user.getName(),
                    extractInfo.getEncodedPassword(user.getPassword()),
                    user.getSex(),
                    user.getRole());
            userRepository.save(u);
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
