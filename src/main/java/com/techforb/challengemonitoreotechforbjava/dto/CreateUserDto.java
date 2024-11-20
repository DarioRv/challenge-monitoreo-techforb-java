package com.techforb.challengemonitoreotechforbjava.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreateUserDto implements Serializable {
    @NotNull(message = "El nombre de usuario no puede ser nulo")
    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @NotEmpty(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 4, max = 15, message = "El nombre de usuario debe tener entre 4 y 15 caracteres")
    private String username;

    @NotNull(message = "La contraseña no puede ser nula")
    @NotBlank(message = "La contraseña no puede estar vacía")
    @NotEmpty(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 15, message = "La contraseña debe tener entre 8 y 15 caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "La contraseña debe contener al menos una letra minúscula, una letra mayúscula y un número")
    private String password;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacío")
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 4, max = 50, message = "El nombre debe tener entre 4 y 50 caracteres")
    private String name;
}
