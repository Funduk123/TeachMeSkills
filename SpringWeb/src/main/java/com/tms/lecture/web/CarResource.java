package com.tms.lecture.web;

import com.tms.lecture.dto.Car;
import com.tms.lecture.dto.User;
import com.tms.lecture.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/car")
public class CarResource {

    private CarService service;
    private User user;

    public CarResource(CarService service, User user) {
        this.service = service;
        this.user = user;
    }

    @GetMapping
    public ModelAndView home(@ModelAttribute Car car) {
        Map<String, Object> model = new HashMap<>();
        model.put("testCar", new Car("testCar", "testPassword"));
        return new ModelAndView("home", model);
    }

    @PostMapping
    public ModelAndView save(@Valid Car car, BindingResult result) {

//        if (result.hasErrors()) {
//
//            ModelAndView modelAndView = new ModelAndView("home");
//            Map<String, String> errors = new HashMap<>();
//
//            List<FieldError> fieldErrors = result.getFieldErrors();
//
//            for (FieldError error : fieldErrors) {
//                errors.put("err_" + error.getField(), error.getDefaultMessage());
//            }
//
//            modelAndView.addAllObjects(errors);
//
//            return modelAndView;
//        }

        user.setLogin("Danila");
        user.setPassword("12345");
        service.save(car);
        return new ModelAndView("home");
    }

}

//            @RequestParam(name = "number") String carNumber,
//            @RequestParam(required = false, defaultValue = "defaultPassword") String password,
//            @RequestHeader(name = "head", required = false, defaultValue = "defaultHead") String head,
//            @CookieValue(name = "cookie") String cookie,
//            @PathVariable(name = "type") String goodType