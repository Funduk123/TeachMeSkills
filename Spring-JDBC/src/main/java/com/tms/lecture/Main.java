package com.tms.lecture;

import com.tms.lecture.domain.User;
import com.tms.lecture.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms");

        UserService bean = context.getBean(UserService.class);

        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        User user3 = new User("user3", "password3");

        bean.save(user1);
        bean.save(user2);
        bean.save(user3);

        user1.setLogin("new_user1");
        user1.setPassword("new_password1");
        bean.update(user1);

        bean.delete(user1);

        UUID user2Uuid = user2.getUuid();
        User byId = bean.getById(user2Uuid);
        System.out.println(byId);

        List<User> userList = bean.getAll();
        System.out.println("All users: " + userList);

        List<User> usersByLogin = bean.getByLogin("user3");
        System.out.println("Users with this login: " + usersByLogin);

    }
}