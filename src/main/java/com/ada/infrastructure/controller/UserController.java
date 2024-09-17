package com.ada.infrastructure.controller;

import com.ada.application.usecases.CreateUser;
import com.ada.application.usecases.ListAllUsers;
import com.ada.domain.entities.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final ListAllUsers listUsers;

    public UserController(CreateUser createUser, ListAllUsers listUsers) {
        this.createUser = createUser;
        this.listUsers = listUsers;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        User saved = createUser.create(
                new User(userDto.name(), userDto.birthDate(), userDto.email()));

        return new UserDto(saved.getName(), saved.getBirthDate(), saved.getEmail());
    }

    @GetMapping
    public List<UserDto> listAllUsers() {
        return listUsers.listAllUsers().stream()
                .map(user -> new UserDto(user.getName(), user.getBirthDate(), user.getEmail()))
                .toList();
    }
}
