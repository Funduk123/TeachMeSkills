package com.tms.lecture.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private UUID uuid;
    private String login;
    private String password;

    public User(String login, String password) {
        this.uuid = UUID.randomUUID();
        this.login = login;
        this.password = password;
    }
}
