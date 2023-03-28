package com.tms.orderservice.client;

import com.tms.orderservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(
        name = "userClient",
        url = "http://127.0.0.1:8091"
)
public interface UserClient {

    @GetMapping("/users")
    List<UserDto> getAll();

    @GetMapping("/users/{id}")
    UserDto getById(@PathVariable(name = "id") UUID id);

    @PostMapping("/users")
    UserDto create(@RequestBody UserDto userDto);

    @PutMapping("/users")
    UserDto update(@RequestBody UserDto userDto);

    @DeleteMapping("/users/{id}")
    void delete(@PathVariable(name = "id") UUID id);

}
