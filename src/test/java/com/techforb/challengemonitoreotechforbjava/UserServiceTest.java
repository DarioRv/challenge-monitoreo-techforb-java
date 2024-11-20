package com.techforb.challengemonitoreotechforbjava;

import com.techforb.challengemonitoreotechforbjava.dto.CreateUserDto;
import com.techforb.challengemonitoreotechforbjava.dto.UserDto;
import com.techforb.challengemonitoreotechforbjava.exception.http.BadRequestException;
import com.techforb.challengemonitoreotechforbjava.exception.http.NotFoundException;
import com.techforb.challengemonitoreotechforbjava.service.IUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    private CreateUserDto createUserDto;
    private UserDto userDto;

    @BeforeEach
    public void setUp() {
        createUserDto = new CreateUserDto();
        createUserDto.setName("John Doe");
        createUserDto.setUsername("johndoe");
        createUserDto.setPassword("password");
    }

    @AfterEach
    public void tearDown() {
        createUserDto = null;
        userDto = null;
    }

    @Test
    public void createUser() {
        assertDoesNotThrow(() -> {
            userDto = userService.createUser(createUserDto);
            assertNotNull(userDto);
            assertNotNull(userDto.getId());
            assertEquals(userDto.getName(), createUserDto.getName());
            assertEquals(userDto.getUsername(), createUserDto.getUsername());
        });

        userService.deleteUser(userDto.getId());
    }

    @Test
    public void createUserWithExistingUsername() {
        assertDoesNotThrow(() -> {
            userDto = userService.createUser(createUserDto);
            assertNotNull(userDto);
            assertNotNull(userDto.getId());
            assertEquals(userDto.getName(), createUserDto.getName());
            assertEquals(userDto.getUsername(), createUserDto.getUsername());
        });

        CreateUserDto createUserDto2 = new CreateUserDto();
        createUserDto2.setName("Jane Doe");
        createUserDto2.setUsername("johndoe");
        createUserDto2.setPassword("password");



        assertThrows(BadRequestException.class, () -> {
            userService.createUser(createUserDto2);
        });

        userService.deleteUser(userDto.getId());
    }

    @Test
    public void deleteUser() {
        userDto = userService.createUser(createUserDto);

        assertDoesNotThrow(() -> {
            userService.deleteUser(userDto.getId());
        });
    }

    @Test
    public void deleteUserWithInvalidId() {
        assertThrows(NotFoundException.class, () -> {
            userService.deleteUser("1234");
        });
    }
}
