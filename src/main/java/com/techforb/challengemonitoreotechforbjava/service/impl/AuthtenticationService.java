package com.techforb.challengemonitoreotechforbjava.service.impl;

import com.techforb.challengemonitoreotechforbjava.dto.Credentials;
import com.techforb.challengemonitoreotechforbjava.dto.UserDto;
import com.techforb.challengemonitoreotechforbjava.entity.User;
import com.techforb.challengemonitoreotechforbjava.exception.http.UnauthorizedException;
import com.techforb.challengemonitoreotechforbjava.repository.IUserRepository;
import com.techforb.challengemonitoreotechforbjava.service.IAuthtenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthtenticationService implements IAuthtenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Map<String, Object> login(Credentials credentials) {
        try {
            var authToken = new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword());
            Authentication authenticate = authenticationManager.authenticate(authToken);
            String username  = modelMapper.map(authenticate.getPrincipal(), User.class).getUsername();

            UserDto userDto = modelMapper.map(userRepository.findByUsername(username), UserDto.class);
            String token = tokenService.generateToken(username);
            return Map.of("token", token, "user", userDto);

        } catch (AuthenticationException e) {
            throw new UnauthorizedException("Credenciales inválidas");
        }
    }
}
