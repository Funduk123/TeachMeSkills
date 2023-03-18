package com.tms.lecture.service;

import com.tms.lecture.dto.Car;
import com.tms.lecture.dto.User;
import com.tms.lecture.exception.MyException;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private User user;

    public CarServiceImpl(User user) {
        this.user = user;
    }

    @Override
    public void save(Car car) {
//        if (car.getNumber().isEmpty() || car.getNumber().isBlank()) {
//            throw new MyException();
//        }
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        System.out.println(car + " was saved");
    }

    @Override
    public void test() {
        throw new MyException();
    }
}
