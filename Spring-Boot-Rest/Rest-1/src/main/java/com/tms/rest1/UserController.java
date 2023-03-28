package com.tms.rest1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @GetMapping
    public List<User> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        var save = repository.save(user);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") UUID id) {

        var userById = repository.findById(id);

        if (userById.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.status(404).build();
    }

}
