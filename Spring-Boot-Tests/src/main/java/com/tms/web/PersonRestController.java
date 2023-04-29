package com.tms.web;

import com.tms.dto.PersonDto;
import com.tms.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonService service;

    @GetMapping
    public ResponseEntity<PersonDto> getByUsername(@RequestParam(name = "username") String username) {
        PersonDto personDto = service.getByUsername(username);
        return ResponseEntity.status(201).body(personDto);
    }


}
