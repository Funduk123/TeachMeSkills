package com.tms.orderservice.service;

import com.tms.orderservice.dto.OrderResponse;
import com.tms.orderservice.dto.StoreRequest;

public interface OrderService {

    OrderResponse createOrder(StoreRequest storeRequest);

}
