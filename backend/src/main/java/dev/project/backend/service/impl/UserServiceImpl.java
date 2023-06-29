package dev.project.backend.service.impl;

import dev.project.backend.dto.Message;
import dev.project.backend.dto.Send;
import dev.project.backend.entities.User;
import dev.project.backend.repository.UserRepository;
import dev.project.backend.service.UserService;
import dev.project.backend.utils.ExtractInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ExtractInfo extractInfo;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
        this.extractInfo = new ExtractInfo();
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
}
