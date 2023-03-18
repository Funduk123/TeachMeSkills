package com.tms.lecture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@SessionScope
public class User {

    private String login;
    private String password;

}
