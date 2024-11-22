package com.techforb.challengemonitoreotechforbjava.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UpdatePlantDto implements Serializable {
    @NotNull(message = "Las lecturas no pueden ser nulas")
    @PositiveOrZero(message = "Las lecturas deben ser un valor positivo o cero")
    private int readings;

    @NotNull(message = "Las alertas medias no pueden ser nulas")
    @PositiveOrZero(message = "Las alertas medias deben ser un valor positivo o cero")
    private int mediumAlerts;

    @NotNull(message = "Las alertas rojas no pueden ser nulas")
    @PositiveOrZero(message = "Las alertas rojas deben ser un valor positivo o cero")
    private int redAlerts;

    @NotNull(message = "Los sensores deshabilitados no pueden ser nulos")
    @PositiveOrZero(message = "Los sensores deshabilitados deben ser un valor positivo o cero")
    private int sensorsDisabled;
}
