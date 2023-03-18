package homework.service;

import homework.config.DBConnectionConfig;
import homework.dto.CarDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseCarService implements CarService {

    DBConnectionConfig dbConnection = new DBConnectionConfig();

    List<CarDto> carsDB = new ArrayList<>();

    @Override
    public CarDto saveCar(CarDto car) {
        if (!carsDB.contains(car)) {
            Connection connection = dbConnection.getConnection();
            try {
                String sql = "insert into cars (id, brand, model, cost) values (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, car.getId());
                preparedStatement.setString(2, car.getBrand());
                preparedStatement.setString(3, car.getModel());
                preparedStatement.setLong(4, car.getCost());
                preparedStatement.executeUpdate();
                System.out.println("Car " + car.getId() + " saved in DB");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return car;
    }

    @Override
    public void deleteCar(Long id) {
        try (Connection connection = dbConnection.getConnection()) {
            String sql = "DELETE FROM cars WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Delete car from BD");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CarDto getCar(Long id) {
        CarDto car = new CarDto();
        try (Connection connection = dbConnection.getConnection()) {
            String sql = "SELECT * FROM cars WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car = new CarDto(resultSet.getLong("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getLong("cost"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Машина " + car + " из базы данных");
        return car;
    }

    @Override
    public List<CarDto> getAllCars() {
        List<CarDto> carsList = new ArrayList<>();
        try (Connection connection = dbConnection.getConnection()) {
            String sql = "SELECT * FROM cars";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                carsList.add(
                        new CarDto(resultSet.getLong("id"),
                                resultSet.getString("brand"),
                                resultSet.getString("model"),
                                resultSet.getLong("cost"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All cars from DB: " + carsList);
        return carsList;
    }

    @Override
    public CarDto updateCar(CarDto car) {
        try (Connection connection = dbConnection.getConnection()) {
            String sql = "UPDATE cars SET cost = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(2, car.getId());
            preparedStatement.setLong(1, car.getCost() + 1000);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Машина обновлена в БД");
        return getCar(car.getId());
    }
}
