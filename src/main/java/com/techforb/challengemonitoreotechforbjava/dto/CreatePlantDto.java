package com.techforb.challengemonitoreotechforbjava.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreatePlantDto implements Serializable {
    @NotNull(message = "El país no puede ser nulo")
    @NotBlank(message = "El país no puede estar vacío")
    @NotEmpty(message = "El país no puede estar vacío")
    private String country;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacío")
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull(message = "El código de país no puede ser nulo")
    @NotBlank(message = "El código de país no puede estar vacío")
    @NotEmpty(message = "El código de país no puede estar vacío")
    private String countryCode;
}
