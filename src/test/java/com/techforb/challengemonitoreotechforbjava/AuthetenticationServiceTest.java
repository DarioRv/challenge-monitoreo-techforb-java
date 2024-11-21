package com.techforb.challengemonitoreotechforbjava;

import com.techforb.challengemonitoreotechforbjava.dto.CreateUserDto;
import com.techforb.challengemonitoreotechforbjava.dto.Credentials;
import com.techforb.challengemonitoreotechforbjava.dto.UserDto;
import com.techforb.challengemonitoreotechforbjava.exception.http.UnauthorizedException;
import com.techforb.challengemonitoreotechforbjava.service.IAuthtenticationService;
import com.techforb.challengemonitoreotechforbjava.service.IUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AuthetenticationServiceTest {
    @Autowired
    private IAuthtenticationService authtenticationService;
    @Autowired
    private IUserService userService;

    private CreateUserDto createUserDto;
    private UserDto userDto;

    @BeforeEach
    public void setUp() {
        createUserDto = new CreateUserDto();
        createUserDto.setName("John Doe");
        createUserDto.setUsername("johndoe");
        createUserDto.setPassword("JohnDoe123");
        createUserDto.setEmail("johndoe@mail.com");
    }

    @AfterEach
    public void tearDown() {
        createUserDto = null;
        userDto = null;
    }

    @Test
    public void login() {
        Credentials credentials = new Credentials();
        credentials.setEmail(createUserDto.getEmail());
        credentials.setPassword(createUserDto.getPassword());
        userDto = userService.createUser(createUserDto);

        assertDoesNotThrow(() -> authtenticationService.login(credentials));

        userService.deleteUser(userDto.getId());
    }

    @Test
    public void loginWithInvalidCredentials() {
        userDto = userService.createUser(createUserDto);

        Credentials credentials = new Credentials();
        credentials.setEmail(createUserDto.getEmail());
        credentials.setPassword("12345-invalid");

        assertThrows(UnauthorizedException.class, () -> authtenticationService.login(credentials));

        userService.deleteUser(userDto.getId());
    }
}
