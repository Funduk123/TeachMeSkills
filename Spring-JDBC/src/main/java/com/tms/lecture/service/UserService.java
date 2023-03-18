package com.tms.lecture.service;

import com.tms.lecture.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void save(User user);

    void update(User user);

    void delete(User user);

    User getById(UUID uuid);

    List<User> getAll();

    List<User> getByLogin(String login);

}
