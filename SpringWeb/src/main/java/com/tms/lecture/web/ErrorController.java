package com.tms.lecture.web;

import com.tms.lecture.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(MyException.class)
    public String processError(Exception exc) {
        return "error";
    }

}
