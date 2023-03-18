package com.tms.lecture.web;

import com.tms.lecture.exception.MyException;
import com.tms.lecture.service.CarService;
import com.tms.lecture.service.CarServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookResource {

    private CarService service;

    public BookResource(CarService service) {
        this.service = service;
    }

    @GetMapping
    public String test() {
        service.test();
        return "test.jsp";
    }

}
