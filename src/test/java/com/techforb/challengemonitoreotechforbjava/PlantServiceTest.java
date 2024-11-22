package com.techforb.challengemonitoreotechforbjava;

import com.techforb.challengemonitoreotechforbjava.dto.CreatePlantDto;
import com.techforb.challengemonitoreotechforbjava.dto.PlantDto;
import com.techforb.challengemonitoreotechforbjava.dto.UpdatePlantDto;
import com.techforb.challengemonitoreotechforbjava.exception.http.NotFoundException;
import com.techforb.challengemonitoreotechforbjava.service.IPlantService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PlantServiceTest {
    @Autowired
    private IPlantService plantService;

    private CreatePlantDto createPlantDto;
    private PlantDto plantDto;
    private UpdatePlantDto updatePlantDto;

    @BeforeEach
    public void setUp() {
        createPlantDto = new CreatePlantDto();
        createPlantDto.setName("Cordoba");
        createPlantDto.setCountry("Argentina");
        createPlantDto.setCountryCode("AR");
    }

    @AfterEach
    public void tearDown() {
        createPlantDto = null;
        plantDto = null;
    }

    @Test
    public void createPlant() {
        assertDoesNotThrow(() -> {
            plantDto = plantService.createPlant(createPlantDto);
            assertNotNull(plantDto);
            assertNotNull(plantDto.getId());
            assertEquals(plantDto.getName(), createPlantDto.getName());
            assertEquals(plantDto.getCountry(), createPlantDto.getCountry());
            assertEquals(plantDto.getCountryCode(), createPlantDto.getCountryCode());
        });

        plantService.deletePlant(plantDto.getId());
    }

    @Test
    public void updatePlant() {
        assertDoesNotThrow(() -> {
            plantDto = plantService.createPlant(createPlantDto);
            assertNotNull(plantDto);
            assertNotNull(plantDto.getId());
            assertEquals(plantDto.getName(), createPlantDto.getName());
            assertEquals(plantDto.getCountry(), createPlantDto.getCountry());
            assertEquals(plantDto.getCountryCode(), createPlantDto.getCountryCode());

            updatePlantDto = new UpdatePlantDto();
            updatePlantDto.setReadings(10);
            updatePlantDto.setMediumAlerts(10);
            updatePlantDto.setRedAlerts(10);
            updatePlantDto.setSensorsDisabled(10);

            PlantDto updatedPlantDto = plantService.updatePlant(plantDto.getId(), updatePlantDto);
            assertNotNull(updatedPlantDto);
            assertEquals(updatedPlantDto.getId(), plantDto.getId());
            assertEquals(updatedPlantDto.getName(), plantDto.getName());
            assertEquals(updatedPlantDto.getCountry(), plantDto.getCountry());
            assertEquals(updatedPlantDto.getCountryCode(), plantDto.getCountryCode());
        });

        plantService.deletePlant(plantDto.getId());
    }

    @Test
    public void deletePlant() {
        plantDto = plantService.createPlant(createPlantDto);

        assertDoesNotThrow(() -> {
            plantService.deletePlant(plantDto.getId());
        });
    }

    @Test
    public void deleteNonExistingPlant() {
        assertThrows(NotFoundException.class, () -> {
            plantService.deletePlant("1234-invalid");
        });
    }

    @Test
    public void getPlant() {
        plantDto = plantService.createPlant(createPlantDto);

        assertDoesNotThrow(() -> {
            PlantDto plantDtoFounded = plantService.getPlant(plantDto.getId());
            assertNotNull(plantDtoFounded);
            assertEquals(plantDtoFounded.getId(), plantDto.getId());
            assertEquals(plantDtoFounded.getName(), plantDto.getName());
            assertEquals(plantDtoFounded.getCountry(), plantDto.getCountry());
            assertEquals(plantDtoFounded.getCountryCode(), plantDto.getCountryCode());
        });

        plantService.deletePlant(plantDto.getId());
    }

    @Test
    public void getNonExistingPlant() {
        assertThrows(NotFoundException.class, () -> {
            plantService.getPlant("1234-invalid");
        });
    }

}
