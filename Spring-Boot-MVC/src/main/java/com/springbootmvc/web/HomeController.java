package com.springbootmvc.web;

import com.springbootmvc.domain.CarDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView home(@RequestParam(name = "role", required = false) String role) {

        ModelAndView modelAndView = new ModelAndView("home.html");
        modelAndView.addObject("car", new CarDto("BMW", "x5", 15));
        modelAndView.addObject("carMap", Map.of("car", new CarDto("AUDI", "A6", 20)));

        if ("admin".equalsIgnoreCase(role)) {
            modelAndView.addObject("isAdmin", true);
        } else {
            modelAndView.addObject("isAdmin", false);
        }

        return modelAndView;
    }

}
