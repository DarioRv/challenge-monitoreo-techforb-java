package com.techforb.challengemonitoreotechforbjava.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int readings;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int mediumAlerts;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int redAlerts;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int sensorsDisabled;
}
