package com.ada.infrastructure.gateways;

import com.ada.application.gateways.UserRepository;
import com.ada.domain.entities.user.User;
import com.ada.infrastructure.persistence.UserEntity;
import com.ada.infrastructure.persistence.UserRepositoryPersistence;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryJpa implements UserRepository {
    private final UserRepositoryPersistence userRepositoryPersistence;
    private final UserEntityMapper userMaper;

    public UserRepositoryJpa(UserRepositoryPersistence userRepositoryPersistence, UserEntityMapper userMaper) {
        this.userRepositoryPersistence = userRepositoryPersistence;
        this.userMaper = userMaper;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = userMaper.toEntity(user);
        userRepositoryPersistence.save(userEntity);
        return userMaper.toDomain(userEntity);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepositoryPersistence.findAll().stream()
                .map(userMaper::toDomain)
                .collect(Collectors.toList());
    }
}
