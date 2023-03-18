package com.tms.JPA_HQL;

import com.tms.JPA_HQL.domain.Address;
import com.tms.JPA_HQL.domain.Phone;
import com.tms.JPA_HQL.domain.Role;
import com.tms.JPA_HQL.domain.UserEntity;
import com.tms.JPA_HQL.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Main main = new Main();

        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms.JPA_HQL");
        UserService userService = context.getBean(UserService.class);

        userService.save(main.create(Role.USER, "user1"));
        userService.save(main.create(Role.USER, "user2"));
        userService.save(main.create(Role.ADMIN, "user2"));

        System.out.println("-----------------------------------");

//        userService.update(1, "description1");
//        userService.update(1, "description2");
//
//        userService.testOptimisticLock(1, "description3");

//        List<UserEntity> user2 = userService.getBy("user2", Role.ADMIN);

        System.out.println("");
    }

    public UserEntity create(Role role, String login) {
        UserEntity user = new UserEntity();
        user.setLogin(login);
        user.setPassword("password1");
        Address address = new Address("Minsk", "Lenina");
        user.setAddress(address);
        user.setBirthday(new Date());
        user.setRole(role);
        System.out.println("create user = " + user);

        Phone phone1 = new Phone();
        phone1.setNumber(new Random().nextInt());

        Phone phone2 = new Phone();
        phone2.setNumber(new Random().nextInt());

        user.setPhones(List.of(phone1, phone2));

        return user;
    }

}
