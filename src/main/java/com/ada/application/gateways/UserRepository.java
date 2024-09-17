package com.ada.application.gateways;

import com.ada.domain.entities.user.User;

import java.util.List;

public interface UserRepository {
    User createUser(User user);

    List<User> findAllUsers();
}
