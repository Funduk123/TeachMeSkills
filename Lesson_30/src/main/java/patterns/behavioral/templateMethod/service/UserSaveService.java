package patterns.behavioral.templateMethod.service;

import patterns.behavioral.templateMethod.model.User;

import java.util.Date;

public class UserSaveService extends SaveService {

    @Override
    protected boolean birthdayNeeded(Date birthday) {
        System.out.println("User saved in cache");
        return birthday == null;
    }

    @Override
    protected void saveUser(User user) {
        System.out.println("User saved in cache");
    }
}
