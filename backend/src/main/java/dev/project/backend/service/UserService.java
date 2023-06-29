package dev.project.backend.service;

import dev.project.backend.dto.LoginCredentials;
import dev.project.backend.dto.Message;
import dev.project.backend.entities.User;

public interface UserService {
    Message createUser(User user);

    User getUser(String emailID);

    String loginUser(LoginCredentials loginCredentials);
}
