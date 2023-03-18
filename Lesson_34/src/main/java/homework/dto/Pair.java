package homework.dto;

import lombok.Data;

@Data
public class Pair {

    private Horse horse;
    private Rider rider;
    private int overallSpeed;

    public Pair(Horse horse, Rider rider) {
        this.horse = horse;
        this.rider = rider;
        this.overallSpeed = horse.getSpeed() + rider.getExperience() * 5;
    }

    @Override
    public String toString() {
        return "Pair (" + horse.getNumber() +
                ", " + rider.getName() + ") -> " + overallSpeed + "%";
    }

    public void show() {
        System.out.println("Pair (" + horse.getNumber() + ", " + rider.getName() + ")");
    }
}