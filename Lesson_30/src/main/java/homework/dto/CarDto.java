package homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private Long id;
    private String brand;
    private String model;
    private Long cost;

    @Override
    public String toString() {
        return "Car " + id +
                " {brand: " + brand +
                " | model: " + model +
                " | cost: " + cost + "}";
    }
}