package homework.service;

import homework.dto.CarDto;

import java.util.List;

public interface CarService {

    CarDto saveCar(CarDto car);
    
    void deleteCar(Long id);
    
    CarDto getCar(Long id);

    List<CarDto> getAllCars();
    
    CarDto updateCar(CarDto car);

}
