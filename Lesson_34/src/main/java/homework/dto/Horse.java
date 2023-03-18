package homework.dto;

import lombok.Data;

@Data
public class Horse {

    private int number;
    private int speed;

    public Horse(int number) {
        this.number = number;
        this.speed = (int) (Math.random() * 25) + 25;
    }

    @Override
    public String toString() {
        return "Horse № " + number +
                ", speed: " + speed + "%";
    }
}