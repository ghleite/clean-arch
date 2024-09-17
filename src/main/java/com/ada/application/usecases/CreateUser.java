package com.ada.application.usecases;

import com.ada.application.gateways.UserRepository;
import com.ada.domain.entities.user.User;


public class CreateUser {
    private final UserRepository userRepository;

    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.createUser(user);
    }
}
