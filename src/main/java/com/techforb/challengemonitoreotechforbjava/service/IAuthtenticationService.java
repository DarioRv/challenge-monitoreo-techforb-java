package com.techforb.challengemonitoreotechforbjava.service;

import com.techforb.challengemonitoreotechforbjava.dto.Credentials;

import java.util.Map;

public interface IAuthtenticationService {
    Map<String, Object> login(Credentials credentials);
}
