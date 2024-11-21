package com.techforb.challengemonitoreotechforbjava.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Credentials implements Serializable {
    @NotNull(message = "El email no puede ser nulo")
    @NotBlank(message = "El email no puede estar vacío")
    @NotEmpty(message = "El email no puede estar vacío")
    @Email(message = "El email debe tener formato válido")
    private String email;

    @NotNull(message = "La contraseña no puede ser nula")
    @NotBlank(message = "La contraseña no puede estar vacía")
    @NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;
}
