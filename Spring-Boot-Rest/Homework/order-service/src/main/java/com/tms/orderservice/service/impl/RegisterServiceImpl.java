package com.tms.orderservice.service.impl;

import com.tms.orderservice.client.UserClient;
import com.tms.orderservice.dto.RegisterRequest;
import com.tms.orderservice.dto.RegisterResponse;
import com.tms.orderservice.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserClient userClient;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {

        var user = userClient.getById(registerRequest.getId());

        return RegisterResponse.builder()
                .registerId(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }

    @Override
    public void deleteUser(RegisterRequest registerRequest) {
        userClient.delete(registerRequest.getId());
    }

}
