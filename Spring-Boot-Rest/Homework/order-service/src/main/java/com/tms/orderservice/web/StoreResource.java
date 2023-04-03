package com.tms.orderservice.web;

import com.tms.orderservice.dto.ErrorResponse;
import com.tms.orderservice.dto.OrderResponse;
import com.tms.orderservice.dto.StoreRequest;
import com.tms.orderservice.service.OrderService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreResource {

    private final OrderService service;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = OrderResponse.class)))
    })
    public OrderResponse order(@RequestBody StoreRequest storeRequest) {
        return service.createOrder(storeRequest);
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<StoreRequest> processError() {
        return ResponseEntity.badRequest().build();
    }

}
