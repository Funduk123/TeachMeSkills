package com.tms.many_to_many;

import com.tms.many_to_many.domain.Address;
import com.tms.many_to_many.domain.Phone;
import com.tms.many_to_many.domain.UserEntity;
import com.tms.many_to_many.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();

        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms.many_to_many");
        UserService userService = context.getBean(UserService.class);

        userService.save(main.create());
//        userService.save(main.create());
//        userService.save(main.create());

        System.out.println("-----------------------------------");

        UserEntity userEntity = userService.get(1);

        System.out.println(userEntity);

//        List<Phone> phones = userEntity.getPhones();

//
//        Phone phone = userService.getPhone(2);
//        System.out.println(phone);
//
//        userService.delete(1);
    }

    public UserEntity create() {
        UserEntity user = new UserEntity();
        user.setLogin("login" + new Random().nextInt());
        user.setPassword("password1");
        Address address = new Address("Minsk", "Lenina");
        user.setAddress(address);
        user.setBirthday(new Date());
        System.out.println("create user = " + user);

        Phone phone1 = new Phone();
        phone1.setNumber(new Random().nextInt());

        Phone phone2 = new Phone();
        phone2.setNumber(new Random().nextInt());

        user.setPhones(List.of(phone1, phone2));

        return user;
    }

}
