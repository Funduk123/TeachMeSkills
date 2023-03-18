package patterns.structural.adapter.service;

import patterns.structural.adapter.model.User;

public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        System.out.println("Save " + user.getLogin()  + " to database");
    }
}
