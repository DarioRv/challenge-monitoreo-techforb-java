package com.techforb.challengemonitoreotechforbjava.service;

import com.techforb.challengemonitoreotechforbjava.dto.CreatePlantDto;
import com.techforb.challengemonitoreotechforbjava.dto.PlantDto;
import com.techforb.challengemonitoreotechforbjava.dto.UpdatePlantDto;

import java.util.List;

public interface IPlantService {
    PlantDto createPlant(CreatePlantDto createPlantDto);
    PlantDto updatePlant(String id, UpdatePlantDto updatePlantDto);
    PlantDto getPlant(String id);
    List<PlantDto> getPlants();
    boolean deletePlant(String id);
}
