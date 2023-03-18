package com.tms.homework.dto;

import lombok.Data;

@Data
public class Horse {

    private String name;
    private int speed;

    public Horse(String name) {
        this.name = name;
        this.speed = (int) (Math.random() * 25) + 25;
    }

    @Override
    public String toString() {
        return "Horse № " + name +
                ", speed: " + speed + "%";
    }
}