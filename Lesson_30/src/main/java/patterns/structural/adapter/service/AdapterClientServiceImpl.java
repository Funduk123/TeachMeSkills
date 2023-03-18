package patterns.structural.adapter.service;

import patterns.structural.adapter.model.User;

import java.util.Date;

public class AdapterClientServiceImpl implements ClientService {

    UserService userService = new UserServiceImpl();

    @Override
    public void save(String login, String password, Date birthday) {
        var user = new User(login, password, birthday);
        userService.save(user);
    }
}
