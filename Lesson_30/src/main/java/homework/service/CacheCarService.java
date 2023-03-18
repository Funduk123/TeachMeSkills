package homework.service;

import homework.dto.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CacheCarService implements CarService {

    List<CarDto> carsCache = new ArrayList<>();

    CarService carService;

    public CacheCarService(CarService carService) {
        this.carService = carService;
    }

    @Override
    public CarDto saveCar(CarDto car) {
        carService.saveCar(car);
        if (!carsCache.contains(car)) {
            carsCache.add(car);
        }
        System.out.println("Car " + car.getId() + " saved in cache");
        return car;
    }

    @Override
    public void deleteCar(Long id) {
        Optional<CarDto> carOptional = carsCache.stream().filter(c -> c.getId() == id).findFirst();
        carOptional.ifPresent(carsCache::remove);
        carService.deleteCar(id);
        System.out.println("Delete car from cache");
    }

    @Override
    public CarDto getCar(Long id) {
        Optional<CarDto> carOptional = carsCache.stream().filter(c -> c.getId() == id).findFirst();
        if (carOptional.isPresent()) {
            System.out.println("Выбрана " + carOptional.get() + " из кэша");
            return carOptional.get();
        } else {
            CarDto car = carService.getCar(id);
            if (car != null) {
                carsCache.add(car);
            }
            return car;
        }
    }

    @Override
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @Override
    public CarDto updateCar(CarDto car) {
        carsCache.remove(car);
        return carService.updateCar(car);
    }

}
