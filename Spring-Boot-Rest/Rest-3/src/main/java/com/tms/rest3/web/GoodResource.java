package com.tms.rest3.web;

import com.tms.rest3.exc.ErrorResponse;
import com.tms.rest3.exc.GoodNotFoundException;
import com.tms.rest3.model.GoodEntity;
import com.tms.rest3.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodResource {

    private final GoodService service;

    @PostMapping("/{name}")
    public GoodEntity get(@PathVariable(name = "name") String name) {
        return service.getByName(name);
    }

    @ExceptionHandler(GoodNotFoundException.class)
    public ErrorResponse processError(GoodNotFoundException exc) {
        return new ErrorResponse(exc.getError());
    }

}
