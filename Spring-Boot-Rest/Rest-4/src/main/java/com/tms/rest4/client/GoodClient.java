package com.tms.rest4.client;

import com.tms.rest4.dto.GoodDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "goodClient",
        url = "http://127.0.0.1:8082"
)
public interface GoodClient {

    @PostMapping("/goods/{name}")
    GoodDto get(@PathVariable(name = "name") String name);

}
