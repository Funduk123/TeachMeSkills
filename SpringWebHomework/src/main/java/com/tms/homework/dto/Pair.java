package com.tms.homework.dto;

import lombok.Data;

@Data
public class Pair {

    private Integer id;
    private Horse horse;
    private Rider rider;
    private int overallSpeed;

    public Pair(Integer id, Horse horse, Rider rider) {
        this.id = id;
        this.horse = horse;
        this.rider = rider;
        this.overallSpeed = horse.getSpeed() + rider.getExperience() * 5;
    }

    @Override
    public String toString() {
        return "Pair " + id + " (" + horse.getName() +
                ", " + rider.getName() + ")";
    }

}