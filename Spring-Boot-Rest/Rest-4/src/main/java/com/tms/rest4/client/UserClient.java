package com.tms.rest4.client;

import com.tms.rest4.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "userClient",
        url = "http://127.0.0.1:8081"
)
public interface UserClient {

    @GetMapping("/users/{login}")
    UserDto get(@PathVariable(name = "login") String login);

}
