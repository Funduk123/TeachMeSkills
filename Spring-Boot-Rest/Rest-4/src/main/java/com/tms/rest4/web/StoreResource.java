package com.tms.rest4.web;

import com.tms.rest4.dto.ErrorResponse;
import com.tms.rest4.dto.OrderResponse;
import com.tms.rest4.dto.StoreRequest;
import com.tms.rest4.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreResource {

    private final OrderService service;

    @PostMapping
    public OrderResponse order(@RequestBody StoreRequest request) {
        return service.makeOrder(request);
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> processError() {
        return ResponseEntity.badRequest().build();
    }

}
