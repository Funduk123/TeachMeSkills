package com.tms.springbootsecurity.repository;

import com.tms.springbootsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);

}
