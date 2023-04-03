package com.tms.orderservice.service;

import com.tms.orderservice.dto.RegisterRequest;
import com.tms.orderservice.dto.RegisterResponse;

import java.util.List;

public interface RegisterService {

    RegisterResponse register(RegisterRequest registerRequest);

    void deleteUser(RegisterRequest registerRequest);

}
