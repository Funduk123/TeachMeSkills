package patterns.behavioral.templateMethod.service;

import patterns.behavioral.templateMethod.model.User;

import java.util.Date;

public class AdminSaveService extends SaveService {

    @Override
    protected boolean birthdayNeeded(Date birthday) {
        return false;
    }

    @Override
    protected void saveUser(User user) {
        System.out.println("Admin saved in db");
    }
}
