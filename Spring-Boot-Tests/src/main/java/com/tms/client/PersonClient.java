package com.tms.client;

import com.tms.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "personClient",
        url = "${client.person.url}"
)
public interface PersonClient {

    @GetMapping("/validate_person")
    PersonDto validate();

}
