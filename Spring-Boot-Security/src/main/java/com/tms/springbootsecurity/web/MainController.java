package com.tms.springbootsecurity.web;

import com.tms.springbootsecurity.model.User;
import com.tms.springbootsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.security.RolesAllowed;
import java.util.UUID;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    @GetMapping("/mainpage")
    public String main() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "main-page.html";
    }

    @GetMapping("/loginpage")
    public String login() {
        return "login-page.html";
    }

    @GetMapping("/pageread")
    public String read() {
        return "page-read.html";
    }

    @GetMapping("/pagewrite")
    public String write() {
        return "page-write.html";
    }

    @GetMapping("/pageuser")
    public String user() {
        return "page-user.html";
    }

    @GetMapping("/pageadmin")
    public String admin() {
        return "page-admin.html";
    }

    @GetMapping("/test")
//    @Secured({"ROLE_USER"})
    @RolesAllowed("ROLE_USER")
    public String test() {
        return "";
    }

    @PostMapping("/create")
    public String create(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setPassword(encoder.encode(password));
        user.setUsername(username);
        user.setAuth("USER");
        repository.save(user);
        return "login-page.html";
    }

}