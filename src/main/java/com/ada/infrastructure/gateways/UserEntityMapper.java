package com.ada.infrastructure.gateways;

import com.ada.domain.entities.user.User;
import com.ada.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getName(), user.getBirthDate(), user.getEmail());
    }

    public User toDomain(UserEntity userEntity) {
        return new User(userEntity.getName(), userEntity.getBirthDate(), userEntity.getEmail());
    }
}
