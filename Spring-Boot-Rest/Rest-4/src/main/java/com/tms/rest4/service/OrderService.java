package com.tms.rest4.service;

import com.tms.rest4.dto.OrderResponse;
import com.tms.rest4.dto.StoreRequest;

public interface OrderService {

    OrderResponse makeOrder(StoreRequest dto);

}
