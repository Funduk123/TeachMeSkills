package homework;

import homework.config.DBConnectionConfig;
import homework.dto.CarDto;
import homework.service.CacheCarService;
import homework.service.CarService;
import homework.service.DataBaseCarService;

public class Main {
    public static void main(String[] args) {

        DBConnectionConfig connection = new DBConnectionConfig();
        connection.initialization();

        CarService carService = new CacheCarService(new DataBaseCarService());

        CarDto car1 = new CarDto(1L, "a1", "b1", 1L);
        CarDto car2 = new CarDto(2L, "a2", "b2", 2L);
        CarDto car3 = new CarDto(3L, "a3", "b3", 3L);

        carService.saveCar(car1);
        carService.saveCar(car2);
        carService.saveCar(car3);

        carService.getAllCars();

        carService.getCar(2L);

        carService.deleteCar(1L);

        carService.getAllCars();

        System.out.println("Обновлена: " + carService.updateCar(car2));

    }
}
