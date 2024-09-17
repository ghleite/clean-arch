package com.ada.user;

import com.ada.domain.entities.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    public void testUserCreationSuccess() {
        String name = "Fulano";
        LocalDate birthDate = LocalDate.now().minusYears(18);
        String email = "fulano@example.com";

        User user = new User(name, birthDate, email);

        assertNotNull(user);
        assertEquals(name, user.getName());
        assertEquals(birthDate, user.getBirthDate());
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testUserCreationUnderage() {
        String name = "fulano";
        LocalDate birthDate = LocalDate.now().minusYears(17);
        String email = "fulano@example.com";

        Executable executable = () -> new User(name, birthDate, email);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals("User must be at least 18 years old", exception.getMessage());
    }

}
