package com.tms.orderservice.client;

import com.tms.orderservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@FeignClient(
        name = "userClient",
        url = "http://127.0.0.1:8091/users"
)
public interface UserClient {

    @GetMapping
    List<UserDto> getAll();

    @GetMapping("/{id}")
    UserDto getById(@PathVariable(name = "id") UUID id);

    @PostMapping
    UserDto create(@RequestBody UserDto userDto);

    @PutMapping
    UserDto update(@RequestBody UserDto userDto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable(name = "id") UUID id);

}
