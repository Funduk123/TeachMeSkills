package com.tms.springtokenrest.service;

import com.tms.springtokenrest.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public User getByUsername(String username) {

        if (username != null && username.equals("Sergey")) {
            return User.builder()
                    .login("Sergey")
                    .password("password")
                    .auths(List.of("user", "admin"))
                    .build();
        } else {
            return null;
        }

    }

}
