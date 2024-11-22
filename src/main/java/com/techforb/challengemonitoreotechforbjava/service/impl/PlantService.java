package com.techforb.challengemonitoreotechforbjava.service.impl;

import com.techforb.challengemonitoreotechforbjava.dto.CreatePlantDto;
import com.techforb.challengemonitoreotechforbjava.dto.PlantDto;
import com.techforb.challengemonitoreotechforbjava.dto.UpdatePlantDto;
import com.techforb.challengemonitoreotechforbjava.entity.Plant;
import com.techforb.challengemonitoreotechforbjava.exception.http.HttpException;
import com.techforb.challengemonitoreotechforbjava.exception.http.InternalServerErrorException;
import com.techforb.challengemonitoreotechforbjava.exception.http.NotFoundException;
import com.techforb.challengemonitoreotechforbjava.repository.IPlantRepository;
import com.techforb.challengemonitoreotechforbjava.service.IPlantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService implements IPlantService {
    @Autowired
    private IPlantRepository plantRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PlantDto createPlant(CreatePlantDto createPlantDto) throws HttpException {
        try {
            Plant plant = modelMapper.map(createPlantDto, Plant.class);
            plant = plantRepository.save(plant);
            return modelMapper.map(plant, PlantDto.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("Error al crear la planta");
        }
    }

    @Override
    public PlantDto updatePlant(String id, UpdatePlantDto updatePlantDto) throws HttpException {
        Plant plant = plantRepository.findById(id).orElse(null);
        if (plant == null) {
            throw new NotFoundException("La planta con id " + id + " no existe");
        }

        try {
            plant.setReadings(updatePlantDto.getReadings());
            plant.setMediumAlerts(updatePlantDto.getMediumAlerts());
            plant.setRedAlerts(updatePlantDto.getRedAlerts());
            plant.setSensorsDisabled(updatePlantDto.getSensorsDisabled());

            return modelMapper.map(plantRepository.save(plant), PlantDto.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("Error al actualizar la planta");
        }
    }

    @Override
    public PlantDto getPlant(String id) throws HttpException {
        Plant plant = plantRepository.findById(id).orElse(null);
        if (plant == null) {
            throw new NotFoundException("La planta con id " + id + " no existe");
        }

        return modelMapper.map(plant, PlantDto.class);
    }

    @Override
    public List<PlantDto> getPlants() {
        List<Plant> plants = plantRepository.findAll();
        List<PlantDto> plantDtos = new ArrayList<>();

        for (Plant plant : plants) {
            plantDtos.add(modelMapper.map(plant, PlantDto.class));
        }

        return plantDtos;
    }

    @Override
    public boolean deletePlant(String id) throws HttpException {
        Plant plant = plantRepository.findById(id).orElse(null);
        if (plant == null) {
            throw new NotFoundException("La planta con id " + id + " no existe");
        }

        plantRepository.delete(plant);
        return true;
    }
}
