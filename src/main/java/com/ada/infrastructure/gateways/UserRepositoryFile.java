package com.ada.infrastructure.gateways;

import com.ada.application.gateways.UserRepository;
import com.ada.domain.entities.user.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryFile implements UserRepository {
    List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        this.users.add(user);
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return this.users;
    }

    public void saveInFile(String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.users.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
