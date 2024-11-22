package com.techforb.challengemonitoreotechforbjava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DatosController {
    @GetMapping("/summary")
    public List<Integer> getSummary() {
        return List.of(1234, 932, 932, 932);
    }

    @GetMapping("/temperature")
    public List<Integer> getTemperature() {
        return List.of(10, 20, 3);
    }

    @GetMapping("/pressure")
    public List<Integer> getPressure() {
        return List.of(10, 20, 3);
    }

    @GetMapping("/wind")
    public List<Integer> getWind() {
        return List.of(10, 20, 3);
    }

    @GetMapping("/levels")
    public List<Integer> getLevels() {
        return List.of(10, 20, 3);
    }

    @GetMapping("/energy")
    public List<Integer> getEnergy() {
        return List.of(10, 20, 3);
    }

    @GetMapping("/stress")
    public List<Integer> getStress() {
        return List.of(10, 20, 3);
    }

    @GetMapping("/carbon-monoxide")
    public List<Integer> getCarbonMonoxide() {
        return List.of(10, 20, 3);
    }

    @GetMapping("/other-gases")
    public List<Integer> getOtherGases() {
        return List.of(10, 20, 3);
    }
}
