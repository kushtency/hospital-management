package dev.project.backend.service;

import dev.project.backend.dto.CombinedInfo;
import dev.project.backend.dto.LoginCredentials;
import dev.project.backend.dto.Message;
import dev.project.backend.entities.User;

public interface UserService {
    Message createUser(CombinedInfo user);

    User getUser(String emailID);

    String loginUser(LoginCredentials loginCredentials);
}
