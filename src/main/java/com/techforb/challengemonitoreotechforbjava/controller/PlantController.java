package com.techforb.challengemonitoreotechforbjava.controller;

import com.techforb.challengemonitoreotechforbjava.dto.CreatePlantDto;
import com.techforb.challengemonitoreotechforbjava.dto.UpdatePlantDto;
import com.techforb.challengemonitoreotechforbjava.service.IPlantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/plants")
public class PlantController {
    @Autowired
    private IPlantService plantService;

    @PostMapping()
    public ResponseEntity<?> createPlant(@Valid @RequestBody CreatePlantDto createPlantDto) {
        Map<String, Object> response = Map.of("data", plantService.createPlant(createPlantDto));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePlant(@PathVariable String id, @Valid @RequestBody UpdatePlantDto updatePlantDto) {
        Map<String, Object> response = Map.of("data", plantService.updatePlant(id, updatePlantDto));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlant(@PathVariable String id) {
        Map<String, Object> response = Map.of("data", plantService.getPlant(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getPlants() {
        Map<String, Object> response = Map.of("data", plantService.getPlants());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlant(@PathVariable String id) {
        Map<String, Object> response = Map.of("data", plantService.deletePlant(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
