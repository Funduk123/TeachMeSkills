package com.tms.one_to_one;

import com.tms.one_to_one.domain.Address;
import com.tms.one_to_one.domain.Phone;
import com.tms.one_to_one.domain.UserEntity;
import com.tms.one_to_one.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();

        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms.one_to_one");
        UserService userService = context.getBean(UserService.class);

        userService.save(main.create());
        userService.save(main.create());
        userService.save(main.create());

        System.out.println("-----------------------------------");

        UserEntity userEntity = userService.get(2);
        System.out.println(userEntity);

        Phone phone = userService.getPhone(2);
        System.out.println(phone);

        userService.delete(1);
    }

    public UserEntity create() {
        UserEntity user = new UserEntity();
        user.setLogin("login" + new Random().nextInt());
        user.setPassword("password1");
        Address address = new Address("Minsk", "Lenina");
        user.setAddress(address);
        user.setBirthday(new Date());
        System.out.println("create user = " + user);

        Phone phone = new Phone();
        phone.setNumber(new Random().nextInt());
        user.setPhone(phone);

        return user;
    }

}
