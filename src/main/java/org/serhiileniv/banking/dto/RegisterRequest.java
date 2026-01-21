package org.serhiileniv.banking.dto;


import jakarta.validation.constraints.*;

public record RegisterRequest(
        @NotBlank(message = "Ім'я обов'язкове")
        String name,

        @NotBlank(message = "Прізвище обов'язкове")
        String surname,

        @Email(message = "Некоректний формат email")
        @NotBlank(message = "Email обов'язковий")
        String email,

        @NotBlank(message = "Телефон обов'язковий")
        String phone,

        @Size(min = 8, message = "Пароль має бути не менше 8 символів")
        @NotBlank(message = "Пароль обов'язковий")
        String password
) {}