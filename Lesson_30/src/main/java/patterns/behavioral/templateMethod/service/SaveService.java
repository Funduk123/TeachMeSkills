package patterns.behavioral.templateMethod.service;

import patterns.behavioral.templateMethod.model.User;

import java.util.Date;

public abstract class SaveService {

    public void save(String login, String password, Date birthday) {

        var user = new User(login, password, birthday);
        System.out.println("User was created");

        if (user.getLogin() == null || user.getPassword() == null || birthdayNeeded(user.getBirthday())) {
            throw new RuntimeException("User is not valid");
        }

        saveUser(user);

    }

    protected abstract boolean birthdayNeeded(Date birthday);
    protected abstract void saveUser(User user);
}
