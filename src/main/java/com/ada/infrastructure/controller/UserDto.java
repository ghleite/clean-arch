package com.ada.infrastructure.controller;

import java.time.LocalDate;

public record UserDto(
    String name,
    LocalDate birthDate,
    String email
) {
}
