package com.ada.config;

import com.ada.application.gateways.UserRepository;
import com.ada.application.usecases.CreateUser;
import com.ada.application.usecases.ListAllUsers;
import com.ada.infrastructure.gateways.UserEntityMapper;
import com.ada.infrastructure.gateways.UserRepositoryJpa;
import com.ada.infrastructure.persistence.UserRepositoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUser createUser(UserRepository userRepository) {
        return new CreateUser(userRepository);
    }

    @Bean
    ListAllUsers listAllUsers(UserRepository userRepository) {
        return new ListAllUsers(userRepository);
    }

    @Bean
    UserRepositoryJpa createUserRepositoryJpa(UserRepositoryPersistence userRepository, UserEntityMapper userMaper) {
        return new UserRepositoryJpa(userRepository, userMaper);
    }

    @Bean
    UserEntityMapper returnUserEntityMapper() {
        return new UserEntityMapper();
    }
}
