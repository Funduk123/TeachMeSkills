package com.tms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kek")
public class HandleResource {

    @GetMapping
    public String getHome() {
        return "home.jsp";
    }

}
