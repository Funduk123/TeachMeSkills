package com.tms.lecture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @NotBlank
    private String number;

    @Size(min = 2, max = 10)
    @NotBlank
    private String password;

}
