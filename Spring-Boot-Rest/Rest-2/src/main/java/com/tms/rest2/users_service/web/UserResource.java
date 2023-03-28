package com.tms.rest2.users_service.web;

import com.tms.rest2.users_service.exc.ErrorResponse;
import com.tms.rest2.users_service.exc.UserNotFoundException;
import com.tms.rest2.users_service.model.UserEntity;
import com.tms.rest2.users_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

    @GetMapping("/{login}")
    public UserEntity get(@PathVariable(name = "login") String login) {
        return service.getByLogin(login);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> processError(UserNotFoundException exc) {
        return ResponseEntity
                .status(404)
                .body(new ErrorResponse(exc.getError()));
    }

}
