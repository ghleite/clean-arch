package com.ada.application.usecases;

import com.ada.application.gateways.UserRepository;
import com.ada.domain.entities.user.User;

import java.util.List;

public class ListAllUsers {

    private final UserRepository userRepository;

    public ListAllUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAllUsers() {
        return userRepository.findAllUsers();
    }

}
