package com.tms.orderservice.web;

import com.tms.orderservice.dto.RegisterRequest;
import com.tms.orderservice.dto.RegisterResponse;
import com.tms.orderservice.service.RegisterService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@Tag(name = "RegisterAPI")
public class RegisterResource {

    private final RegisterService registerService;

    @PostMapping
    @ApiResponses(
            value = {
                    @ApiResponse(description = "Register user", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    name = "RegisterSchema", implementation = RegisterResponse.class
                            )
                    ))
            }
    )
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        return registerService.register(registerRequest);
    }

    @DeleteMapping
    @ApiResponses(
            value = {
                    @ApiResponse(description = "Delete user")
            }
    )
    public void delete(@RequestBody RegisterRequest registerRequest) {
        registerService.deleteUser(registerRequest);
    }
}
