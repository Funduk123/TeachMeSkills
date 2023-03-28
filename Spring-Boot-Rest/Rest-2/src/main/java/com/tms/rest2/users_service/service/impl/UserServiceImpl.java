package com.tms.rest2.users_service.service.impl;

import com.tms.rest2.users_service.exc.UserNotFoundException;
import com.tms.rest2.users_service.model.UserEntity;
import com.tms.rest2.users_service.repository.UserRepository;
import com.tms.rest2.users_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @PostConstruct
    public void init() {
        UserEntity user1 = UserEntity.builder()
                .id(UUID.randomUUID())
                .login("Sergey")
                .build();

        UserEntity user2 = UserEntity.builder()
                .id(UUID.randomUUID())
                .login("Danila")
                .build();

        repository.save(user1);
        repository.save(user2);
    }

    public UserEntity getByLogin(String login) {
        return repository.findByLogin(login)
                .orElseThrow(() -> new UserNotFoundException("User with login " + login + " not found!"));
    }

}
