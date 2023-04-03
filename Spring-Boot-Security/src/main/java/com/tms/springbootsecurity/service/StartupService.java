package com.tms.springbootsecurity.service;

import com.tms.springbootsecurity.model.User;
import com.tms.springbootsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final UserRepository repository;

    @PostConstruct
    public void init() {

        User userRead = User.builder()
                .id(UUID.randomUUID())
                .username("user1")
                .password("user1")
                .auth("read")
                .build();

        User userWrite = User.builder()
                .id(UUID.randomUUID())
                .username("user2")
                .password("user2")
                .auth("write")
                .build();

        User user = User.builder()
                .id(UUID.randomUUID())
                .username("user")
                .password("user")
                .auth("ROLE_USER")
                .build();

        User admin = User.builder()
                .id(UUID.randomUUID())
                .username("admin")
                .password("admin")
                .auth("ROLE_ADMIN")
                .build();

        repository.save(user);
        repository.save(admin);
        repository.save(userRead);
        repository.save(userWrite);
    }

}
