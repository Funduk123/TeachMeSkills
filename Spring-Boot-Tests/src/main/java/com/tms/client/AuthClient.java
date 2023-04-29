package com.tms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "authClient",
        url = "${client.auth.url}"
)
public interface AuthClient {

    @GetMapping("/validate_auth")
    void validate();

}
