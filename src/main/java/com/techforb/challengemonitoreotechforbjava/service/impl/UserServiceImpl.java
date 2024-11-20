package com.techforb.challengemonitoreotechforbjava.service.impl;

import com.techforb.challengemonitoreotechforbjava.dto.CreateUserDto;
import com.techforb.challengemonitoreotechforbjava.dto.UserDto;
import com.techforb.challengemonitoreotechforbjava.entity.User;
import com.techforb.challengemonitoreotechforbjava.exception.http.BadRequestException;
import com.techforb.challengemonitoreotechforbjava.exception.http.HttpException;
import com.techforb.challengemonitoreotechforbjava.exception.http.InternalServerErrorException;
import com.techforb.challengemonitoreotechforbjava.exception.http.NotFoundException;
import com.techforb.challengemonitoreotechforbjava.repository.IUserRepository;
import com.techforb.challengemonitoreotechforbjava.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(CreateUserDto createUserDto) throws HttpException {
        if (userRepository.findByUsername(createUserDto.getUsername()).orElse(null) != null) {
            throw new BadRequestException("El nombre de usuario ya está en uso");
        }

        try {
            createUserDto.setPassword(passwordEncoder.encode(createUserDto.getPassword()));

            User savedUser = userRepository.save(modelMapper.map(createUserDto, User.class));
            return modelMapper.map(savedUser, UserDto.class);
        } catch (Exception e) {
            throw new InternalServerErrorException("No se pudo crear el usuario");
        }
    }

    @Override
    public boolean deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("El usuario con id " + id + " no existe");
        }

        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new InternalServerErrorException("No se pudo eliminar el usuario");
        }
    }

}
