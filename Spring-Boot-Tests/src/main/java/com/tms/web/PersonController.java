package com.tms.web;

import com.tms.dto.PersonDto;
import com.tms.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping
    public ModelAndView get() {
        var personDto = service.save(new PersonDto());
        var modelAndView = new ModelAndView("person.html");
        modelAndView.addObject("person", personDto);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView get(@RequestBody PersonDto personDto) {
        var dto = service.save(personDto);
        var modelAndView = new ModelAndView("person.html");
        modelAndView.addObject("person", dto);
        return modelAndView;
    }

    @GetMapping("/getById")
    public ModelAndView getById(@RequestParam(name = "id") String id) {
        var personDto = service.save(new PersonDto());
        var modelAndView = new ModelAndView("person.html");
        modelAndView.addObject("person", personDto);
        return modelAndView;
    }

}
