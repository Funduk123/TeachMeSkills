package com.tms.userservice.service;

import com.tms.userservice.model.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserEntity> getAll();

    UserEntity save(UserEntity userEntity);

    UserEntity getById(UUID id);

    UserEntity update(UserEntity userEntity);

    void deleteById(UUID id);

}
