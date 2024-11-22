package com.techforb.challengemonitoreotechforbjava.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlantDto implements Serializable {
    private String id;
    private String country;
    private String name;
    private String countryCode;
    private int readings;
    private int mediumAlerts;
    private int redAlerts;
    private int sensorsDisabled;
}
