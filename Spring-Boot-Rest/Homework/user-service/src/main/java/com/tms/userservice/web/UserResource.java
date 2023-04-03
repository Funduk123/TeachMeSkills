package com.tms.userservice.web;

import com.tms.userservice.exc.ErrorResponse;
import com.tms.userservice.exc.UserNotFoundException;
import com.tms.userservice.model.UserEntity;
import com.tms.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

    @GetMapping
    public List<UserEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable(name = "id") UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public UserEntity create(@RequestBody UserEntity userEntity) {
        return service.save(userEntity);
    }

    @PutMapping
    public UserEntity update(@RequestBody UserEntity userEntity) {
        return service.update(userEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        service.deleteById(id);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> processError(UserNotFoundException exc) {
        return ResponseEntity
                .status(404)
                .body(new ErrorResponse(exc.getError()));
    }

}
