package com.springbootmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private String brand;

    private String model;

    private Integer age;

    public String getFullCar() {
        return "brand: " + brand + ", model: " + model + ", age: " + age;
    }

}
