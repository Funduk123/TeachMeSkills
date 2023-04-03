package com.tms.userservice.service.impl;

import com.tms.userservice.exc.UserNotFoundException;
import com.tms.userservice.model.UserEntity;
import com.tms.userservice.repository.UserRepository;
import com.tms.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @PostConstruct
    public void init() {
        UserEntity user1 = UserEntity.builder()
                .id(UUID.randomUUID())
                .login("Danila")
                .password("12345")
                .phone("+375 33 333 33 33")
                .build();

        UserEntity user2 = UserEntity.builder()
                .id(UUID.randomUUID())
                .login("Roman")
                .password("qwe123")
                .phone("+375 44 444 44 44")
                .build();

        repository.save(user1);
        repository.save(user2);
    }

    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    public UserEntity getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found!"));
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        userEntity.setId(userEntity.getId());
        userEntity.setLogin(userEntity.getLogin());
        userEntity.setPhone(userEntity.getPhone());
        return repository.save(userEntity);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
