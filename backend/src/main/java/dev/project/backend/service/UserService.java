package dev.project.backend.service;

import dev.project.backend.dto.Message;
import dev.project.backend.entities.User;

public interface UserService {
    Message createUser(User user);
}
