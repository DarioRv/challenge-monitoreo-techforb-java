package com.techforb.challengemonitoreotechforbjava.service;

import com.techforb.challengemonitoreotechforbjava.dto.CreateUserDto;
import com.techforb.challengemonitoreotechforbjava.dto.UserDto;

public interface IUserService {
    UserDto createUser(CreateUserDto createUserDto);
    boolean deleteUser(String id);
}
