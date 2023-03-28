package com.tms.rest2.users_service.service;

import com.tms.rest2.users_service.model.UserEntity;

public interface UserService {

    UserEntity getByLogin(String login);

}
