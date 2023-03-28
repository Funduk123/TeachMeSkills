package com.tms.rest4.service.impl;

import com.tms.rest4.client.GoodClient;
import com.tms.rest4.client.UserClient;
import com.tms.rest4.dto.GoodDto;
import com.tms.rest4.dto.OrderResponse;
import com.tms.rest4.dto.StoreRequest;
import com.tms.rest4.dto.UserDto;
import com.tms.rest4.service.OrderService;
import com.tms.rest4.web.OrderException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

//    private final RestTemplate template;

    private final UserClient userClient;

    private final GoodClient goodClient;

    @Override
    public OrderResponse makeOrder(StoreRequest dto) {

        var userUrl = "http://127.0.0.1:8081/users/" + dto.getLogin();

        UserDto user;

//        try {
//            user = template.getForObject(userUrl, UserDto.class);
//        } catch (Exception exc) {
//            throw new OrderException();
//        }

        user = userClient.get(dto.getLogin());

        var goodUrl = "http://127.0.0.1:8082/goods/" + dto.getGoodName();

        GoodDto good;

//        try {
//            good = template.postForObject(goodUrl, null, GoodDto.class);
//        } catch (Exception exc) {
//            throw new OrderException();
//        }

        good = goodClient.get(dto.getGoodName());

        return OrderResponse.builder()
                .orderId(UUID.randomUUID())
                .login(user.getLogin())
                .goodName(good.getName())
                .build();
    }

}
